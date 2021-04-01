package com.cjzt.nicapp.retrofit

import retrofit2.http.GET

interface PlaceRetrofit {
    @GET("places")
    suspend fun get () : List<PlaceNetworkEntity>
}