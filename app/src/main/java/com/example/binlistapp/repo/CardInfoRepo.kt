package com.example.binlistapp.repo

import com.example.binlistapp.dto.CardInfo

interface CardInfoRepo {
    fun getAsync(callback: Callback<List<CardInfo>>,bin:String)
    //fun save(cardInfo: CardInfo, callback: Callback<CardInfo>)

    interface Callback<T> {
        fun onSuccess(posts: T) {}
        fun onError(e: Exception) {}
    }
}