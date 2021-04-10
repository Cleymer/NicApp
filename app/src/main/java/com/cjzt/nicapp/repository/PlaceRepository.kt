package com.cjzt.nicapp.repository

import com.cjzt.nicapp.retrofit.NetworkMapper
import com.cjzt.nicapp.retrofit.PlaceRetrofit
import com.cjzt.nicapp.room.CacheMapper
import com.cjzt.nicapp.room.PlaceDao
import com.cjzt.nicapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class PlaceRepository constructor(
    private val placeDao : PlaceDao,
    private val placeRetrofit: PlaceRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getPlaces(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val placeData = placeRetrofit.get()
            val placeMap = networkMapper.mapFromEntityList(placeData)
            for (tempPlace in placeMap){
                placeDao.insert(cacheMapper.mapToEntity(tempPlace))
            }
            val cachePla = placeDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachePla)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}