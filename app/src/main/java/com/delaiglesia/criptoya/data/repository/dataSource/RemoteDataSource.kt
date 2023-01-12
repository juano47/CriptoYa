package com.delaiglesia.criptoya.data.repository.dataSource

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.utils.Currency
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getCryptoPrices(crypto: Currency): Response<CryptoPricesResponse>
    suspend fun getDollarPrices(): Response<DollarPricesResponse>
    suspend fun getUsdtPrice(): Response<ExchangeResponse>
}