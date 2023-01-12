package com.delaiglesia.criptoya.data.db

import androidx.room.*
import com.delaiglesia.criptoya.data.model.ExchangeResponse
import com.delaiglesia.criptoya.data.utils.Currency

@Dao
interface UsdtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsdtPrice(cryptoPrice: ExchangeResponse)

    @Query("DELETE FROM usdt_price WHERE currency = :currency")
    suspend fun deleteUsdtPrice(currency: Currency)

    @Query("SELECT * FROM usdt_price")
    fun getUsdtPrice(): ExchangeResponse
}