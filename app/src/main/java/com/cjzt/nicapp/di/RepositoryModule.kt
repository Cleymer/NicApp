package com.cjzt.nicapp.di

import com.cjzt.nicapp.repository.PlaceRepository
import com.cjzt.nicapp.retrofit.NetworkMapper
import com.cjzt.nicapp.retrofit.PlaceRetrofit
import com.cjzt.nicapp.room.CacheMapper
import com.cjzt.nicapp.room.PlaceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePlaceRepository(
        placeDao: PlaceDao,
        placeRetrofit: PlaceRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): PlaceRepository {
        return PlaceRepository(placeDao, placeRetrofit, cacheMapper, networkMapper)
    }
}