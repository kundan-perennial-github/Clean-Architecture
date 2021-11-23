package com.perennial.crypto_clean_architecture.domain.repository

import com.perennial.crypto_clean_architecture.domain.model.Coin

interface CoinRepository {

    suspend fun getCoins(): List<Coin>
}