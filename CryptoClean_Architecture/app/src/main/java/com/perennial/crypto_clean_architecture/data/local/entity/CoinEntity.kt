package com.perennial.crypto_clean_architecture.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.perennial.crypto_clean_architecture.domain.model.Coin

@Entity
data class CoinEntity(
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    @PrimaryKey val id: Int? = null
) {
    fun toCoin(): Coin {
        return Coin(
            is_active = is_active,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }
}
