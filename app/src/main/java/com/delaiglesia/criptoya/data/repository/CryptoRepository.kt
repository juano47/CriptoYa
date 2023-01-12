package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.utils.Currency
import com.delaiglesia.criptoya.presentation.utils.Action
import com.delaiglesia.newsapp.data.utils.Resource

interface CryptoRepository {

    suspend fun getCryptoPrices(crypto: Currency, action: Action): Resource<CryptoPricesResponse?>
    suspend fun getDollarPrices(action: Action): Resource<DollarPricesResponse?>
    suspend fun getUsdtPrice(action: Action): Resource<ExchangeResponse?>
}