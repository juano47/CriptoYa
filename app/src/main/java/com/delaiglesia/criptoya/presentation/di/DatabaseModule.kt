package com.delaiglesia.criptoya.presentation.di

import android.app.Application
import androidx.room.Room
import com.delaiglesia.unitconverterapp.data.CryptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): CryptoDatabase {
        return Room.databaseBuilder(app, CryptoDatabase::class.java, "crypto_database.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideCryptoDao(database: CryptoDatabase) = database.getCryptoDao()

    @Singleton
    @Provides
    fun provideDollarDao(database: CryptoDatabase) = database.getDollarDao()

    @Singleton
    @Provides
    fun provideUsdtDao(database: CryptoDatabase) = database.getUsdtDao()
}