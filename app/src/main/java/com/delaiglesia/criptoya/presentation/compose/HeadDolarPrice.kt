package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.delaiglesia.criptoya.R
import com.delaiglesia.criptoya.data.model.DollarPricesResponse

@Composable
fun HeadDollarPrice(
    dollarPrices: DollarPricesResponse?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (dollarPrices != null) {
            dollarPrices.mep?.let {
                PriceCard(
                    price = it,
                    name = "MEP",
                )
            }
            dollarPrices.ccl?.let {
                PriceCard(
                    price = it,
                    name = "CCL",
                )
            }
            dollarPrices.ccb?.let {
                PriceCard(
                    price = it,
                    name = "CRYPTO",
                )
            }
            dollarPrices.blue?.let {
                PriceCard(
                    price = it,
                    name = "BLUE",
                )
            }
        }
    }
}