package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.delaiglesia.criptoya.R

@Composable
fun HeadCryptoPrice(
    modifier: Modifier = Modifier,
    bitcoinPrice: Double,
    ethereumPrice: Double,
) {
    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        PriceCard(
            price = bitcoinPrice,
            name = "Bitcoin",
            icon = R.drawable.bitcoin,
            currency = "US$"
        )
        PriceCard(
            price = ethereumPrice,
            name = "Ethereum",
            icon = R.drawable.ethereum,
            currency = "US$"
        )
    }
}

@Preview
@Composable
fun HeadCriptoPricePreview() {
    HeadCryptoPrice(bitcoinPrice = 100.000, ethereumPrice = 200.000)
}
