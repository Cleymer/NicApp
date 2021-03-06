package com.cjzt.nicapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("image")
    @Expose
    var image: String,
)