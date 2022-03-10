package com.example.travelthru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.ZoneId
import java.util.*

class MainActivity : AppCompatActivity() {
    private var cityNames = arrayOf("hhh", "kkk")
    private var cityTimeDetails = arrayOf("hhh", "kkk")
    private var cityTimes = arrayOf("00:00", "01:00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addCity = findViewById<Button>(R.id.add_city)
        addCity.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(cityNames, cityTimeDetails, cityTimes)
        recyclerView.adapter = adapter

    }
}