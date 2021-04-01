package com.cjzt.nicapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PlaceCacheEntity::class], version = 1)
abstract class PlaceDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "PlaceDB"
    }
    abstract fun placeDao() : PlaceDao
}