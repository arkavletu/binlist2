package com.example.binlistapp.entity

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binlistapp.dto.CardInfo

@Entity
data class CardInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val length: Int,
    val luhn: Boolean,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val bank: String,
    val country: String,
) {
    fun toDto() = CardInfo(
        length, luhn, scheme, type, brand, prepaid, bank, country, id
    )

    companion object {
        fun fromDto(dto: CardInfo) = CardInfoEntity(
            dto.id, dto.length, dto.luhn, dto.scheme, dto.type,
            dto.brand, dto.prepaid, dto.bank, dto.country
        )
    }
}