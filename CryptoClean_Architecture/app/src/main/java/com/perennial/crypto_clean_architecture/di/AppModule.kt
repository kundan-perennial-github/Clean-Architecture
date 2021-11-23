package com.perennial.crypto_clean_architecture.di

import android.app.Application
import androidx.room.Room
import com.perennial.crypto_clean_architecture.common.Constants
import com.perennial.crypto_clean_architecture.data.local.CoinDatabase
import com.perennial.crypto_clean_architecture.data.remote.api.CoinApi
import com.perennial.crypto_clean_architecture.data.repository.CoinRepositoryImpl
import com.perennial.crypto_clean_architecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi, db: CoinDatabase): CoinRepository {
        return CoinRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): CoinDatabase {
        return Room.databaseBuilder(
            app, CoinDatabase::class.java, "coin_db"
        ).build()
    }
}