package com.example.binlistapp.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Number(
    @SerializedName("length")
    @Expose
    val length: Int,
    @SerializedName("luhn")
    @Expose
    val luhn: Boolean

)