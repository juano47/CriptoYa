package com.delaiglesia.criptoya.data.repository

import com.delaiglesia.criptoya.data.db.CryptoDao
import com.delaiglesia.criptoya.data.db.DollarDao
import com.delaiglesia.criptoya.data.db.UsdtDao
import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.criptoya.data.utils.Currency
import com.delaiglesia.criptoya.presentation.utils.Action
import com.delaiglesia.newsapp.data.utils.Resource
import retrofit2.Response

class CryptoRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val cryptoDao: CryptoDao,
    private val dollarDao: DollarDao,
    private val usdtDao: UsdtDao
) : CryptoRepository {

    override suspend fun getCryptoPrices(crypto: Currency, action: Action): Resource<CryptoPricesResponse?> {
        var resultFromDb: CryptoPricesResponse? = null
        when (action) {
            Action.GET -> {
                resultFromDb = cryptoDao.getCryptoPrice(crypto.toString())
            }
            Action.UPDATE -> {
                cryptoDao.deleteCryptoPrice(crypto)
            }
        }

        if (resultFromDb == null) {
            getCryptoPricesFromApi(crypto).let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.crypto  = crypto
                        cryptoDao.insertCryptoPrice(resource.data!!)
                        resultFromDb = resource.data
                    }
                }
            }
        }
        return Resource.Success(resultFromDb)
    }

    override suspend fun getDollarPrices(action: Action): Resource<DollarPricesResponse?> {
        var resultFromDb: DollarPricesResponse? = null
        when (action) {
            Action.GET -> {
                resultFromDb = dollarDao.getDollarPrice()
            }
            Action.UPDATE -> {
                dollarDao.deleteDollarPrice(Currency.USD)
            }
        }

        if (resultFromDb == null) {
            getDollarPricesFromApi().let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.currency  = Currency.USD
                        dollarDao.insertDollarPrice(resource.data!!)
                        resultFromDb = resource.data
                    }
                }
            }
        }
        return Resource.Success(resultFromDb)
    }

    override suspend fun getUsdtPrice(action: Action): Resource<ExchangeResponse?> {
        var resultFromDb: ExchangeResponse? = null
        when (action) {
            Action.GET -> {
                resultFromDb = usdtDao.getUsdtPrice()
            }
            Action.UPDATE -> {
                usdtDao.deleteUsdtPrice(Currency.USDT)
            }
        }

        if (resultFromDb == null) {
            getUsdtPriceFromApi().let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.currency  = Currency.USDT
                        usdtDao.insertUsdtPrice(resource.data!!)
                        resultFromDb = resource.data
                    }
                }
            }
        }
        return Resource.Success(resultFromDb)
    }

    private suspend fun getCryptoPricesFromApi(crypto: Currency): Resource<CryptoPricesResponse> {
        return responseToResource(remoteDataSource.getCryptoPrices(crypto))
    }

    private suspend fun getDollarPricesFromApi(): Resource<DollarPricesResponse> {
        return responseToResource(remoteDataSource.getDollarPrices())
    }

    private suspend fun getUsdtPriceFromApi(): Resource<ExchangeResponse> {
        return responseToResource(remoteDataSource.getUsdtPrice())
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