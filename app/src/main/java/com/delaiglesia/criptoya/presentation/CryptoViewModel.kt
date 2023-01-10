package com.delaiglesia.unitconverterapp

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.newsapp.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoViewModel(private val app: Application, private val repository: CryptoRepository) :
    ViewModel() {

    val bitcoinPrice: MutableState<Double> = mutableStateOf(0.0)
    val ethereumPrice: MutableState<Double> = mutableStateOf(0.0)

    fun getBitcoinPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCryptoPrices("btc").let {
                when (it) {
                    is Resource.Success -> {
                        bitcoinPrice.value = it.data?.decrypto?.totalAsk ?: 0.0
                    }
                    is Resource.Error -> {
                        bitcoinPrice.value = 0.0
                    }
                }
            }
        }
    }

    fun getEtherPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCryptoPrices("eth").let {
                when (it) {
                    is Resource.Success -> {
                        ethereumPrice.value = it.data?.tiendacrypto?.totalAsk ?: 0.0
                    }
                    is Resource.Error -> {
                        ethereumPrice.value = 0.0
                    }
                }
            }
        }
    }
}