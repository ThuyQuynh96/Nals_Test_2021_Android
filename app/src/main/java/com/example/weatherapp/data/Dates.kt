package com.example.weatherapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "dates", indices = [Index(value = ["title"], unique = true)])
data class Dates(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "title") @SerialName("title") var title: String = "",
    @ColumnInfo(name = "weather_state_abbr") @SerialName("weather_state_abbr") val weather_state_abbr: String?,
    @ColumnInfo(name = "the_temp") @SerialName("the_temp") val the_temp: String?,
    @ColumnInfo(name = "weather_state_name") @SerialName("weather_state_name") val weather_state_name: String?,
    @ColumnInfo(name = "applicable_date") @SerialName("applicable_date") val applicable_date: String?
)
