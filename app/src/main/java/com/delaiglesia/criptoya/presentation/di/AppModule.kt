package com.delaiglesia.criptoya.presentation.di

import com.delaiglesia.criptoya.BuildConfig
import com.delaiglesia.criptoya.data.api.ApiService
import com.delaiglesia.criptoya.data.repository.CryptoRepository
import com.delaiglesia.criptoya.data.repository.CryptoRepositoryImpl
import com.delaiglesia.criptoya.data.repository.dataSource.RemoteDataSource
import com.delaiglesia.criptoya.data.repository.dataSourceImpl.RemoteDataSourceImpl
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

    @Singleton
    @Provides
    fun provideNewsRepository(remoteDataSource: RemoteDataSource): CryptoRepository =
        CryptoRepositoryImpl(remoteDataSource)


}