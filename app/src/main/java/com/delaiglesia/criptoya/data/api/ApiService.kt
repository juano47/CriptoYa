package com.delaiglesia.criptoya.data.api

import com.delaiglesia.criptoya.data.model.CryptoPriceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{crypto}/usd")
    suspend fun getCryptoPrices(
        @Path("crypto") crypto: String
    ): Response<CryptoPriceResponse>
}