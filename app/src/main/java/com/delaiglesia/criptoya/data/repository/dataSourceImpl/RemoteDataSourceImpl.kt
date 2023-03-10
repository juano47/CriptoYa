package com.delaiglesia.criptoya.data.repository.dataSourceImpl

import com.delaiglesia.criptoya.data.api.ApiService
import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.criptoya.data.utils.Currency
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getCryptoPrices(crypto: Currency): Response<CryptoPricesResponse> {
        return apiService.getCryptoPrices(crypto)
    }

    override suspend fun getDollarPrices(): Response<DollarPricesResponse> {
        return apiService.getDollarPrices()
    }

    override suspend fun getUsdtPrice(): Response<ExchangeResponse> {
        return apiService.getUsdtPrice()
    }


}