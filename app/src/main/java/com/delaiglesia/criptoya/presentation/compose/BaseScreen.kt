package com.delaiglesia.criptoya.presentation.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.delaiglesia.criptoya.presentation.CryptoViewModelFactory
import com.delaiglesia.unitconverterapp.CryptoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.presentation.utils.Currency
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun BaseScreen(
    factory: CryptoViewModelFactory,
    modifier: Modifier = Modifier,
    cryptoViewModel: CryptoViewModel = viewModel(factory = factory),
    context: Context = LocalContext.current
) {
    cryptoViewModel.getBitcoinPrice()
    cryptoViewModel.getEtherPrice()
    cryptoViewModel.getDollarPrices()
    cryptoViewModel.getUsdtPrice()
    val prices = mapOf(
        Currency.BTC to cryptoViewModel.bitcoinPrice.value,
        Currency.ETH to cryptoViewModel.ethereumPrice.value,
        Currency.USD to cryptoViewModel.dollarPrices.value,
        Currency.USDT to cryptoViewModel.usdtPrice.value
    )

    val isRefreshing = cryptoViewModel.isRefreshing

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { refresh(context, cryptoViewModel, prices) },
        indicator = { state, trigger ->
            CustomViewPullRefreshView(state, trigger)
        }
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            HeadComponent()
            Column(modifier = modifier.padding(20.dp, 0.dp)) {
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp))
                HeadCryptoPrice(
                    bitcoinPrice = (prices[Currency.BTC] ?: 0.0) as Double,
                    ethereumPrice = (prices[Currency.ETH] ?: 0.0) as Double,
                )
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp))
                HeadDollarPrice(dollarPrices = prices[Currency.USD] as DollarPricesResponse?)
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp))
                ExchangePrice(price = prices[Currency.USDT] as Double)
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp))
            }
        }
    }
}

@Composable
fun CustomViewPullRefreshView(
    swipeRefreshState: SwipeRefreshState,
    refreshTriggerDistance: Dp,
    color: Color = Color.Blue
) {
    Box(
        Modifier
            .drawWithCache {
                onDrawBehind {
                    val distance = refreshTriggerDistance.toPx()
                    val progress = (swipeRefreshState.indicatorOffset / distance).coerceIn(0f, 1f)
                    val brush = Brush.verticalGradient(
                        0f to color.copy(alpha = 0.45f),
                        1f to color.copy(alpha = 0f)
                    )
                    drawRect(
                        brush = brush,
                        alpha = FastOutSlowInEasing.transform(progress)
                    )
                }
            }
            .fillMaxWidth()
            .height(80.dp)
    ) {
        if (swipeRefreshState.isRefreshing) {
            LinearProgressIndicator(
                Modifier.fillMaxWidth(),
                color = Color.White
            )
        } else {
            val trigger = with(LocalDensity.current) { refreshTriggerDistance.toPx() }
            val progress = (swipeRefreshState.indicatorOffset / trigger).coerceIn(0f, 1f)
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            )
        }
    }
}

fun refresh(context: Context, cryptoViewModel: CryptoViewModel, prices: Map<Currency, Any?>) {
    cryptoViewModel.getBitcoinPrice()
    cryptoViewModel.getEtherPrice()
    cryptoViewModel.getDollarPrices()
    cryptoViewModel.getUsdtPrice()

    //check 0.0 value in the map
    if (prices.containsValue(0.0)) {
        Toast.makeText(context, "Some prices couldn't be updated", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Prices updated!", Toast.LENGTH_SHORT).show()
    }
}
