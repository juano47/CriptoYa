package com.delaiglesia.criptoya.data.db

import androidx.room.*
import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.utils.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptoPrice(cryptoPrice: CryptoPricesResponse)

    @Query("DELETE FROM crypto_price WHERE crypto = :crypto")
    suspend fun deleteCryptoPrice(crypto: Currency)

    @Query("SELECT * FROM crypto_price where crypto = :crypto")
    suspend fun getCryptoPrice(crypto: String): CryptoPricesResponse
}