package com.example.binlistapp.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CardInfo(
    @SerializedName("number")
    @Expose
    val number: Number,
    @SerializedName("scheme")
    @Expose
    val scheme: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("brand")
    @Expose
    val brand: String,
    @SerializedName("prepaid")
    @Expose
    val prepaid: Boolean,
    @SerializedName("country")
    @Expose
    val country: Country,
    @SerializedName("bank")
    @Expose
    val bank: Bank,
    val id: Long = 0L
)