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
        return GregorianCalendar(timezone).time.toString()
    }

    private fun setCityTimeDetail(): Int {
        val timezone = TimeZone.getTimeZone(this.cityName)
        return GregorianCalendar(timezone).get(Calendar.ZONE_OFFSET)/(60*60*1000)
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