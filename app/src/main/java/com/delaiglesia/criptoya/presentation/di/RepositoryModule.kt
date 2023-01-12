package com.delaiglesia.criptoya.presentation.di

import com.delaiglesia.criptoya.data.db.CryptoDao
import com.delaiglesia.criptoya.data.db.DollarDao
import com.delaiglesia.criptoya.data.db.UsdtDao
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.criptoya.data.repository.CryptoRepositoryImpl
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCryptoRepository(
        remoteDataSource: RemoteDataSource,
        cryptoDao: CryptoDao,
        dollarDao: DollarDao,
        usdtDao: UsdtDao
    ): CryptoRepository =
        CryptoRepositoryImpl(remoteDataSource, cryptoDao, dollarDao, usdtDao)
}