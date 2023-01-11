package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.delaiglesia.criptoya.R

@Composable
fun ExchangePrice(
    modifier: Modifier = Modifier,
    price: Double,
) {
    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        PriceCard(
            price = price,
            name = "USDT - Buenbit",
            iconId = R.drawable.usdt,
            currency = "US$"
        )
    }
}