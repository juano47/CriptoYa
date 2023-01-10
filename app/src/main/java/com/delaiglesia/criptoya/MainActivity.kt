package com.delaiglesia.criptoya

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.delaiglesia.criptoya.presentation.compose.BaseScreen
import com.delaiglesia.criptoya.ui.theme.CriptoYaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptoYaTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        BaseScreen()
                    }

                }
            }
        }
    }
}