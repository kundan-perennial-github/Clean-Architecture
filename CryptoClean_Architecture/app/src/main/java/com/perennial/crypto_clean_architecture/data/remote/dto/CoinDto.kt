package com.perennial.crypto_clean_architecture.data.remote.dto

import com.perennial.crypto_clean_architecture.data.local.entity.CoinEntity
import com.perennial.crypto_clean_architecture.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoinEntity(): CoinEntity {
    return CoinEntity(
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )

}