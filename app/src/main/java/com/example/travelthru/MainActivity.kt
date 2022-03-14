package com.example.travelthru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var cities = ArrayList<CityTimeCard>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            val name = bundle.getString("cityName") // 1
            if (name != null) {
                cities.add(CityTimeCard(name))
            }
        } else {
            cities.add(CityTimeCard("Vancouver"))
        }

        val addCity = findViewById<Button>(R.id.add_city)
        addCity.setOnClickListener {
            val intent = Intent(this, AddCityActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(cities)
        recyclerView.adapter = adapter
    }
}