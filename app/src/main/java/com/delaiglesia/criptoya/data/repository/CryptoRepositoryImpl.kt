package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.BitcoinPriceResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.newsapp.data.utils.Resource
import retrofit2.Response

class CryptoRepositoryImpl(
    private val newsRemoteDataSource: RemoteDataSource,
) : CryptoRepository {

    override suspend fun getBitcoinPrices(): Resource<BitcoinPriceResponse> {
        return responseToResource(newsRemoteDataSource.getBitcoinPrices())
    }

    private fun responseToResource(response: Response<BitcoinPriceResponse>): Resource<BitcoinPriceResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error("No results found")
    }
}