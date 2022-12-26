package com.example.binlistapp.model

import com.example.binlistapp.dto.CardInfo

data class FeedModel(
    val posts: List<CardInfo> = emptyList(),
    val loading: Boolean = false,
    val error: Boolean = false,
    val empty: Boolean = false
    //val refreshing: Boolean = false,
)