package com.perennial.crypto_clean_architecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.perennial.crypto_clean_architecture.data.local.entity.CoinEntity

@Database(entities = [CoinEntity::class], version = 1)
abstract class CoinDatabase : RoomDatabase() {

    abstract val dao: CoinDao
}