package com.example.travelthru

import java.util.*

class CityTimeCard (name: String) {
    private var cityName: String = ""
    private var cityTimeDetail: String = ""
    private var cityTime: String = ""

    init {
        this.cityName = name
        this.cityTime = setCityTime()
        this.cityTimeDetail = setCityTimeDetail()
    }

    private fun setCityTime(): String {
        val tz = TimeZone.getTimeZone(this.cityName)
        val calender = Calendar.getInstance(tz)
        return calender.time.toString()
    }

    private fun setCityTimeDetail(): String {
        val tz = TimeZone.getTimeZone(this.cityName)
        return "GMT " + tz.rawOffset
    }

    fun getCityName(): String {
        return this.cityName
    }

    fun getCityTime(): String {
        return this.cityTime
    }

    fun getCityTimeDetail(): String {
        return this.cityTimeDetail
    }
}