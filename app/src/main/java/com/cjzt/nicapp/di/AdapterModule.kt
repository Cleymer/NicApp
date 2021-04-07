package com.cjzt.nicapp.di

import android.app.Application
import com.cjzt.nicapp.utils.AdapterPlaces
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterPlaces{
        return AdapterPlaces()
    }
}