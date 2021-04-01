package com.cjzt.nicapp.di

import com.cjzt.nicapp.retrofit.PlaceRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object RetrofitModule {
    @Singleton
    @Provides
    fun providesGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api-cars-test.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun providePlaceService(retrofit: Retrofit.Builder): PlaceRetrofit{
        return retrofit.build().create(PlaceRetrofit::class.java)
    }
}