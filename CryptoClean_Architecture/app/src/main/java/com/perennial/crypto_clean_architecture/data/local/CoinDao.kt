package com.perennial.crypto_clean_architecture.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.perennial.crypto_clean_architecture.data.local.entity.CoinEntity

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coins: List<CoinEntity>)

    @Query("SELECT * FROM  CoinEntity")
    suspend fun getCoins(): List<CoinEntity>
}