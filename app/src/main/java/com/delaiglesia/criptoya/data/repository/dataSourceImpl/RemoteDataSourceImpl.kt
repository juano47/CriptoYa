package com.delaiglesia.criptoya.data.repository.dataSourceImpl

import com.delaiglesia.criptoya.data.api.ApiService
import com.delaiglesia.criptoya.data.model.BitcoinPriceResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getBitcoinPrices(): Response<BitcoinPriceResponse> {
        return apiService.getBitcoinPrices()
    }
}