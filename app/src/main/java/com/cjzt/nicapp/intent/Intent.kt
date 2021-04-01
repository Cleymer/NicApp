package com.cjzt.nicapp.intent

sealed class Intent{
    object GetPlaceEvent: Intent()
    object None: Intent()
}
