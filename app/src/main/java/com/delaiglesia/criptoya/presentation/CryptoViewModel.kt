package com.delaiglesia.unitconverterapp

import androidx.lifecycle.ViewModel
import com.delaiglesia.criptoya.data.repository.CryptoRepository

class CryptoViewModel(private val repository: CryptoRepository): ViewModel() {

    suspend fun getBitcoinPrice() = repository.getBitcoinPrice()
}