package com.example.travelthru

import java.time.OffsetDateTime
import java.util.*

class CityTimeCard (name: String) {
    private var cityName: String = ""
    private var cityTimeDetail: Int = 0
    private var cityTime: String = ""

    init {
        this.cityName = name
        this.cityTime = setCityTime()
        this.cityTimeDetail = setCityTimeDetail()
    }

    private fun setCityTime(): String {
        val timezone = TimeZone.getTimeZone(this.cityName)
        val calender = Calendar.getInstance(timezone)
        return calender.time.toString()
    }

    private fun setCityTimeDetail(): Int {
        val timezone = TimeZone.getTimeZone(this.cityName)
        return GregorianCalendar.getInstance(timezone).timeZone.rawOffset
    }

    fun getCityName(): String {
        return this.cityName
    }

    fun getCityTime(): String {
        return this.cityTime
    }

    fun getCityTimeDetail(): Int {
        return this.cityTimeDetail
    }
}