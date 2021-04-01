package com.cjzt.nicapp.utils

import com.cjzt.nicapp.model.Place
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val places:List<Place>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()

}
