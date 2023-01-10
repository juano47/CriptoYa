package com.delaiglesia.criptoya.data.api

import com.delaiglesia.criptoya.data.model.BitcoinPriceResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("btc/usd")
    suspend fun getBitcoinPrices(): Response<BitcoinPriceResponse>
}