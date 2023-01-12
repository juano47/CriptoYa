package com.delaiglesia.criptoya.data.db

import androidx.room.*
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.utils.Currency

@Dao
interface DollarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDollarPrice(cryptoPrice: DollarPricesResponse)

    @Query("DELETE FROM dollar_price WHERE currency = :currency")
    suspend fun deleteDollarPrice(currency: Currency)

    @Query("SELECT * FROM dollar_price")
    fun getDollarPrice(): DollarPricesResponse
}