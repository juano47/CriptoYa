package com.delaiglesia.criptoya.data.repository.dataSource

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getCryptoPrices(cryptoType: String): Response<CryptoPricesResponse>
    suspend fun getDollarPrices(): Response<DollarPricesResponse>
    suspend fun getUsdtPrice(): Response<ExchangeResponse>
}