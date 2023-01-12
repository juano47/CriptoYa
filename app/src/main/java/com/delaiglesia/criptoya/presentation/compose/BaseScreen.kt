package com.delaiglesia.criptoya.presentation.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.delaiglesia.criptoya.presentation.CryptoViewModelFactory
import com.delaiglesia.unitconverterapp.CryptoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.utils.Currency
import com.delaiglesia.criptoya.presentation.utils.Action
import com.delaiglesia.newsapp.presentation.utils.CheckNetwork
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun BaseScreen(
    factory: CryptoViewModelFactory,
    modifier: Modifier = Modifier,
    cryptoViewModel: CryptoViewModel = viewModel(factory = factory),
    context: Context = LocalContext.current
) {
    cryptoViewModel.getBitcoinPrice(Action.GET)
    cryptoViewModel.getEtherPrice(Action.GET)
    cryptoViewModel.getDollarPrices(Action.GET)
    cryptoViewModel.getUsdtPrice(Action.GET)
    val prices = mapOf(
        Currency.BTC to cryptoViewModel.bitcoinPrice.value,
        Currency.ETH to cryptoViewModel.ethereumPrice.value,
        Currency.USD to cryptoViewModel.dollarPrices.value,
        Currency.USDT to cryptoViewModel.usdtPrice.value
    )

    val isRefreshing = cryptoViewModel.isRefreshing

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { refreshPrices(context, cryptoViewModel, prices) },
        indicator = { state, trigger ->
            CustomViewPullRefreshView(state, trigger)
        }
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            HeadComponent()
            Column(modifier = modifier.padding(20.dp, 0.dp)) {
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp)
                )
                HeadCryptoPrice(
                    bitcoinPrice = (prices[Currency.BTC] ?: 0.0) as Double,
                    ethereumPrice = (prices[Currency.ETH] ?: 0.0) as Double,
                )
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp)
                )
                HeadDollarPrice(dollarPrices = prices[Currency.USD] as DollarPricesResponse?)
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp)
                )
                ExchangePrice(price = prices[Currency.USDT] as Double)
                Divider(
                    color = Color.White, thickness = 1.dp,
                    modifier = modifier.padding(0.dp, 20.dp)
                )
            }
        }
    }
}

private fun refreshPrices(
    context: Context,
    cryptoViewModel: CryptoViewModel,
    prices: Map<Currency, Any?>
) {
    if(CheckNetwork.isNetworkAvailable(context)) {
        cryptoViewModel.updatePrices()

        if (prices.containsValue(0.0)) {
            Toast.makeText(context, "Some prices couldn't be updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Prices updated!", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(context, "No Internet connection", Toast.LENGTH_SHORT).show()
    }
}
