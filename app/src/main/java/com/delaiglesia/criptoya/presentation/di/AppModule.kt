package com.delaiglesia.criptoya.presentation.di

import android.app.Application
import androidx.room.Room
import com.delaiglesia.criptoya.BuildConfig
import com.delaiglesia.criptoya.data.api.ApiService
import com.delaiglesia.criptoya.data.db.CryptoDao
import com.delaiglesia.criptoya.data.db.DollarDao
import com.delaiglesia.criptoya.data.db.UsdtDao
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.criptoya.data.repository.CryptoRepositoryImpl
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.criptoya.data.repository.dataSourceImpl.RemoteDataSourceImpl
import com.delaiglesia.unitconverterapp.data.CryptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}