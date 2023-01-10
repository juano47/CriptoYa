package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.delaiglesia.criptoya.presentation.CryptoViewModelFactory
import com.delaiglesia.unitconverterapp.CryptoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun BaseScreen(
    factory: CryptoViewModelFactory,
    modifier: Modifier = Modifier,
    cryptoViewModel: CryptoViewModel = viewModel(factory = factory)
) {
    cryptoViewModel.getBitcoinPrice()
    cryptoViewModel.getEtherPrice()
    cryptoViewModel.getDollarPrices()
    val bitcoinPrice = cryptoViewModel.bitcoinPrice.value
    val ethereumPrice = cryptoViewModel.ethereumPrice.value
    val dollarPrices = cryptoViewModel.dollarPrices.value

    HeadComponent()
    Column(modifier = modifier.padding(40.dp, 0.dp)) {
        Divider(
            color = Color.White, thickness = 1.dp,
            modifier = modifier.padding(0.dp, 20.dp))
        HeadCryptoPrice(
            bitcoinPrice = bitcoinPrice,
            ethereumPrice = ethereumPrice,
        )
        Divider(
            color = Color.White, thickness = 1.dp,
            modifier = modifier.padding(0.dp, 20.dp))
        HeadDollarPrice(dollarPrices = dollarPrices)
    }
}
