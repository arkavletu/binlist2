package com.example.binlistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.binlistapp.entity.CardInfoEntity

@Dao
interface CardInfoDao {
    @Query("SELECT * FROM CardInfoEntity ORDER BY id DESC")
    fun getAll(): LiveData<List<CardInfoEntity>>

    @Insert
    fun insert(entity: CardInfoEntity)
}