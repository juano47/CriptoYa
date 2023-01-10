package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delaiglesia.criptoya.R

@Composable
fun PriceCard(
    modifier: Modifier = Modifier,
    price: Double,
    name: String,
    iconId: Int? = null,
    currency: String? = null,
) {

    Column {
        Row {
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (iconId != null) {
                        Icon(
                            painter = painterResource(id = iconId),
                            contentDescription = name
                        )
                    }
                    Text(
                        text = name,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        Row {
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (currency != null) {
                        Text(text = currency)
                    }
                    Text(
                        text = price.toString(),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PriceCardPreview() {
    PriceCard(
        price = 100.000,
        name = "Bitcoin",
        iconId = R.drawable.bitcoin,
        currency = "US$"
    )
}
