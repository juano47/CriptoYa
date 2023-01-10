package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delaiglesia.criptoya.R

@Composable
fun HeadComponent() {
    Row(
        Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
        Text(
            text = "CriptoYa",
            fontFamily = FontFamily(Font(R.font.nunitonedium)),
            fontSize = 40.sp
        )
        Image(painter = painterResource(id = R.drawable.arflag), contentDescription = "Flag")
    }
}