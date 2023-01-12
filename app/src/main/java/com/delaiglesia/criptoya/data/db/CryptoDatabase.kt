package com.delaiglesia.unitconverterapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delaiglesia.criptoya.data.db.CryptoDao
import com.delaiglesia.criptoya.data.db.DollarDao
import com.delaiglesia.criptoya.data.db.UsdtDao
import com.delaiglesia.criptoya.data.model.CryptoPricesResponse
import com.delaiglesia.criptoya.data.model.DollarPricesResponse
import com.delaiglesia.criptoya.data.model.ExchangeResponse

@Database(
    entities = [
        CryptoPricesResponse::class,
        DollarPricesResponse::class,
        ExchangeResponse::class], version = 1, exportSchema = false
)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun getCryptoDao(): CryptoDao
    abstract fun getDollarDao(): DollarDao
    abstract fun getUsdtDao(): UsdtDao
}