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
    converterViewModel: CryptoViewModel = viewModel(factory = factory)
) {
    TopScreen()
}
