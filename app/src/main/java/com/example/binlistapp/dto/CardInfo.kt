package com.example.binlistapp.dto

data class CardInfo (
    val length: Int,
    val luhn: Boolean,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val bank: String,
    val country: String,
    val id: Long = 0,

    )