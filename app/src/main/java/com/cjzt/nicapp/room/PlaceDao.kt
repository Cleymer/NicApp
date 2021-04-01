package com.cjzt.nicapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlaceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: PlaceCacheEntity): Long
    @Query("select * from lugares")
    suspend fun get(): List<PlaceCacheEntity>
}