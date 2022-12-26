package com.example.binlistapp.repo

import com.example.binlistapp.api.BinlistApi
import com.example.binlistapp.dto.CardInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardInfoRepoImpl: CardInfoRepo {
    override fun getAsync(callback: CardInfoRepo.Callback<List<CardInfo>>, bin:String) {
        BinlistApi.retrofitService.getAll(bin).enqueue(object : Callback<List<CardInfo>> {
            override fun onResponse(call: Call<List<CardInfo>>, response: Response<List<CardInfo>>) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body() ?: throw java.lang.RuntimeException("body is null"))
            }

            override fun onFailure(call: Call<List<CardInfo>>, t: Throwable) {
                //
            }
        })
    }

}