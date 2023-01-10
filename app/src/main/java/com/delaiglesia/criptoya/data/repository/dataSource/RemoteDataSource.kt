package com.delaiglesia.criptoya.data.repository.dataSource

import com.delaiglesia.criptoya.data.model.CryptoPriceResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getCryptoPrices(cryptoType: String): Response<CryptoPriceResponse>
}