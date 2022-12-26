package com.example.binlistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.binlistapp.dao.CardInfoDao
import com.example.binlistapp.entity.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun dao(): CardInfoDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context): AppDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}