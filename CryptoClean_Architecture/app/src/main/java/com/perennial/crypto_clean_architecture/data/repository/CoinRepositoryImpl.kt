package com.perennial.crypto_clean_architecture.data.repository

import com.perennial.crypto_clean_architecture.data.local.CoinDao
import com.perennial.crypto_clean_architecture.data.remote.api.CoinApi
import com.perennial.crypto_clean_architecture.data.remote.dto.toCoinEntity
import com.perennial.crypto_clean_architecture.domain.model.Coin
import com.perennial.crypto_clean_architecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi,
    private val dao: CoinDao
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        try {
            val insertCoin = api.getCoins()
            dao.insertCoin(insertCoin.map { it.toCoinEntity() })
        }catch (e:Exception){
            print("Something went wrong!")
        }

        return dao.getCoins().map { it.toCoin() }
    }
}