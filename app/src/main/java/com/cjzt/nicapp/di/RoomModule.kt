package com.cjzt.nicapp.di

import android.content.Context
import androidx.room.Room
import com.cjzt.nicapp.room.PlaceDao
import com.cjzt.nicapp.room.PlaceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providePlaceDb(@ApplicationContext context: Context): PlaceDatabase{
        return Room.databaseBuilder(context, PlaceDatabase::class.java, PlaceDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePlaceDao(placeDatabase: PlaceDatabase): PlaceDao{
        return placeDatabase.placeDao()
    }
}