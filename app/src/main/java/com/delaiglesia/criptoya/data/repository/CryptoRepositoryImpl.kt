package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.newsapp.data.utils.Resource
import retrofit2.Response

class CryptoRepositoryImpl(
    private val newsRemoteDataSource: RemoteDataSource,
) : CryptoRepository {

    override suspend fun getCryptoPrices(crypto: String): Resource<CryptoPricesResponse> {
        return responseToResource(newsRemoteDataSource.getCryptoPrices(crypto))
    }

    override suspend fun getDollarPrices(): Resource<DollarPricesResponse> {
        return responseToResource(newsRemoteDataSource.getDollarPrices())
    }

    override suspend fun getUsdtPrice(): Resource<ExchangeResponse> {
        return responseToResource(newsRemoteDataSource.getUsdtPrice())
    }

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error("No results found")
    }
}