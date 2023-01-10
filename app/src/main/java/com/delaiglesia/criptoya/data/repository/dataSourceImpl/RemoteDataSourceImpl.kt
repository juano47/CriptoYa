package com.delaiglesia.criptoya.data.repository.dataSourceImpl

import com.delaiglesia.criptoya.data.api.ApiService
import com.delaiglesia.criptoya.data.model.CryptoPriceResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getCryptoPrices(crypto: String): Response<CryptoPriceResponse> {
        return apiService.getCryptoPrices(crypto)
    }
}