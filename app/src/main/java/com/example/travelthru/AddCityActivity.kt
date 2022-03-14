package com.example.travelthru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddCityActivity : AppCompatActivity() {
    private val mapFragment = MapsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mapLayout, mapFragment)
        transaction.commit()
    }
}