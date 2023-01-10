package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.newsapp.data.utils.Resource

interface CryptoRepository {

    suspend fun getCryptoPrices(crypto: String): Resource<CryptoPricesResponse>
    suspend fun getDollarPrices(): Resource<DollarPricesResponse>
}