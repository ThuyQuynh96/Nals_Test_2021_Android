package com.example.weatherapp.modun.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {
    @Singleton
    @Provides
    fun provideYourDatabase(@ApplicationContext app: Context): DateDataBase =
        Room.databaseBuilder(app, DateDataBase::class.java, "testdb")
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    fun provideYourDao(db: DateDataBase): DateDao = db.cityDao()
}
