package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.BitcoinPriceResponse
import com.delaiglesia.newsapp.data.utils.Resource

interface CryptoRepository {

    suspend fun getBitcoinPrices(): Resource<BitcoinPriceResponse>
}