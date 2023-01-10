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
            PriceCard(
                price = dollarPrices.mep,
                name = "MEP",
            )
            PriceCard(
                price = dollarPrices.ccl,
                name = "CCL",
            )
            PriceCard(
                price = dollarPrices.ccb,
                name = "CRYPTO",
            )
            PriceCard(
                price = dollarPrices.blue,
                name = "BLUE",
            )
        }
    }
}