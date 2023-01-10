package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    val bitcoinPrice = cryptoViewModel.bitcoinPrice.value
    val ethereumPrice = cryptoViewModel.ethereumPrice.value
    TopScreen(
        bitcoinPrice = bitcoinPrice,
        ethereumPrice = ethereumPrice,
        modifier = modifier)

}
