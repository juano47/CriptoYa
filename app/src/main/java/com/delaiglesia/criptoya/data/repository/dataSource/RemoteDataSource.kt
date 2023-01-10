package com.delaiglesia.criptoya.data.repository.dataSource

import com.delaiglesia.criptoya.data.model.BitcoinPriceResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getBitcoinPrices(): Response<BitcoinPriceResponse>
}