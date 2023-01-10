package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.CryptoPriceResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.newsapp.data.utils.Resource
import retrofit2.Response

class CryptoRepositoryImpl(
    private val newsRemoteDataSource: RemoteDataSource,
) : CryptoRepository {

    override suspend fun getCryptoPrices(crypto: String): Resource<CryptoPriceResponse> {
        return responseToResource(newsRemoteDataSource.getCryptoPrices(crypto))
    }

    private fun responseToResource(response: Response<CryptoPriceResponse>): Resource<CryptoPriceResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error("No results found")
    }
}