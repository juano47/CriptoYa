package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopScreen(
    modifier: Modifier = Modifier,
    bitcoinPrice: Double,
    ethereumPrice: Double,
) {
    HeadComponent()
    Spacer(modifier = modifier.height(10.dp))
    Column(modifier = modifier.padding(40.dp, 0.dp)) {
        HeadCryptoPrice(
            bitcoinPrice = bitcoinPrice,
            ethereumPrice = ethereumPrice,
        )
        HeadDolarPrice()
    }
}