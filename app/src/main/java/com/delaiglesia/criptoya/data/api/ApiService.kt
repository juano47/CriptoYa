package com.delaiglesia.criptoya.data.api

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{crypto}/usd")
    suspend fun getCryptoPrices(
        @Path("crypto") crypto: String
    ): Response<CryptoPricesResponse>

    @GET("dolar")
    suspend fun getDollarPrices(): Response<DollarPricesResponse>
}