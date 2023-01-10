package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.CryptoPriceResponse
import com.delaiglesia.newsapp.data.utils.Resource

interface CryptoRepository {

    suspend fun getCryptoPrices(crypto: String): Resource<CryptoPriceResponse>
}