package com.delaiglesia.criptoya.presentation

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.criptoya.data.utils.Currency
import com.delaiglesia.criptoya.presentation.utils.Action
import com.delaiglesia.newsapp.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoViewModel(private val app: Application, private val repository: CryptoRepository) :
    ViewModel() {

    val bitcoinPrice: MutableState<Double> = mutableStateOf(0.0)
    val ethereumPrice: MutableState<Double> = mutableStateOf(0.0)
    val dollarPrices: MutableState<DollarPricesResponse?> = mutableStateOf(null)
    val usdtPrice: MutableState<Double> = mutableStateOf(0.0)
    val isRefreshing by mutableStateOf(false)

    fun getBitcoinPrice(action: Action) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCryptoPrices(Currency.BTC, action).let {
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

    fun getEtherPrice(action: Action) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCryptoPrices(Currency.ETH, action).let {
                when (it) {
                    is Resource.Success -> {
                        ethereumPrice.value = it.data?.tiendaCrypto?.totalAsk ?: 0.0
                    }
                    is Resource.Error -> {
                        ethereumPrice.value = 0.0
                    }
                }
            }
        }
    }

    fun getDollarPrices(action: Action) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDollarPrices(action).let {
                when (it) {
                    is Resource.Success -> {
                        dollarPrices.value = it.data
                    }
                    is Resource.Error -> {
                        dollarPrices.value = null
                    }
                }
            }
        }
    }

    fun getUsdtPrice(action: Action) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsdtPrice(action).let {
                when (it) {
                    is Resource.Success -> {
                        usdtPrice.value = it.data?.totalBid ?: 0.0
                    }
                    is Resource.Error -> {
                        usdtPrice.value = 0.0
                    }
                }
            }
        }
    }

    fun updatePrices() {
        viewModelScope.launch(Dispatchers.IO) {
            getBitcoinPrice(Action.UPDATE)
            getEtherPrice(Action.UPDATE)
            getDollarPrices(Action.UPDATE)
            getUsdtPrice(Action.UPDATE)
        }
    }
}