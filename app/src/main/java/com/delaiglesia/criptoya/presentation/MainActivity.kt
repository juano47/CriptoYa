package com.delaiglesia.criptoya.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.delaiglesia.criptoya.presentation.compose.BaseScreen
import com.delaiglesia.criptoya.ui.theme.CriptoYaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: CryptoViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptoYaTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        BaseScreen(factory)
                    }

                }
            }
        }
    }
}