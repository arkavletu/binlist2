package com.example.binlistapp.api

import StringArg
import androidx.viewbinding.BuildConfig
import com.example.binlistapp.dto.CardInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://lookup.binlist.net/"

private val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY

}

//Check
private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()

interface BinlistApiService {
    @GET("${BASE_URL}{bin}")
    fun getAll(@Path("bin") bin: String): Call<List<CardInfo>>
}

object BinlistApi {
    val retrofitService: BinlistApiService by lazy {
        retrofit.create(BinlistApiService::class.java)
    }
}