package com.delaiglesia.criptoya.compose

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
fun HeadCriptoPrice(
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.padding(50.dp, 0.dp, 50.dp, 0.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.bitcoin), contentDescription = "Bitcoin")
                    Text(text = "Bitcoin")
                }
            }
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ethereum), contentDescription = "Ether")
                    Text(text = "Ether")
                }
            }


        }
        Spacer(modifier = modifier.height(10.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "US$")
                    Text(text = "100.000")
                }
            }

            Spacer(modifier = modifier.width(10.dp))

            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "US$")
                    Text(text = "200.000")
                }
            }


        }
    }
}

@Preview
@Composable
fun HeadCriptoPricePreview() {
    HeadCriptoPrice()
}
