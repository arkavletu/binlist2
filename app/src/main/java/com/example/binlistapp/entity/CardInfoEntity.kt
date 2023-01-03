package com.example.binlistapp.entity

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.binlistapp.dto.Bank
import com.example.binlistapp.dto.CardInfo
import com.example.binlistapp.dto.Country
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class CardInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val number: com.example.binlistapp.dto.Number,
    val scheme: String,

    val type: String,

    val brand: String,

    val prepaid: Boolean,

    val country: Country,

    val bank: Bank
) {
    fun toDto() = CardInfo(
        number,scheme,type,brand,prepaid,country,bank,id
    )

    companion object {
        fun fromDto(dto: CardInfo) = CardInfoEntity(
            dto.id, dto.number, dto.scheme, dto.type,
            dto.brand, dto.prepaid, dto.country, dto.bank,
        )
    }
}