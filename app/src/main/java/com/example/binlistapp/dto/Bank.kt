package com.example.binlistapp.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Bank(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("phone")
    @Expose
    val phone: String,
    @SerializedName("city")
    @Expose
    val city: String
)