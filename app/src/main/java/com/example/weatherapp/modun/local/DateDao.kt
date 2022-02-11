package com.example.weatherapp.modun.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.Dates

@Dao
interface DateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(cities: MutableList<Dates>)

    @Query("SELECT * FROM dates WHERE id = :dateId")
    suspend fun load(dateId: String): Dates

    @Query("SELECT * FROM dates")
    suspend fun getDates(): MutableList<Dates>
}
