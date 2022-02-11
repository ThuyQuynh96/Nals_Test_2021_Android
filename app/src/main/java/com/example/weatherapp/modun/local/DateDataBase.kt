package com.example.weatherapp.modun.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.data.Dates

@Database(entities = [Dates::class], version = 3)
abstract class DateDataBase : RoomDatabase() {
    abstract fun cityDao(): DateDao
}
