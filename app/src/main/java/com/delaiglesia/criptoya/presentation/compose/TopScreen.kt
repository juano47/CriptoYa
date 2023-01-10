package com.delaiglesia.criptoya.presentation.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopScreen(
    modifier: Modifier = Modifier,
) {
    HeadComponent()
    Spacer(modifier = modifier.height(10.dp))
    HeadCriptoPrice()
    HeadDolarPrice()
}