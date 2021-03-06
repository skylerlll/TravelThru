package com.example.travelthru

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AddCityActivity : AppCompatActivity(), OnMapReadyCallback{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        addMarker(googleMap, LatLng(0.0, 0.0), "Marker")

        googleMap.setOnMapClickListener {
            addMarker(googleMap, it, it.toString())
        }

        val searchBtn = findViewById<ImageButton>(R.id.searchCityBtn)
        searchBtn.setOnClickListener {
            val city = findViewById<TextView>(R.id.searchCity).text.toString()
            if (city != "") {
                val geocoder = Geocoder(this)
                val addressList = geocoder.getFromLocationName(city, 1)
                val address = addressList.get(0)
                val lat = LatLng(address.latitude, address.longitude)
                addMarker(googleMap, lat, city)
            }
        }

        googleMap.setOnMarkerClickListener { marker ->
            val alertDialog: AlertDialog? = this.let {
                val builder = AlertDialog.Builder(it)
                builder.setMessage(R.string.setCity)
                    .setPositiveButton(R.string.yes,
                        DialogInterface.OnClickListener { dialog, id ->
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("cityName", marker.title)
                            startActivity(intent)
                        })
                    .setNegativeButton(R.string.cancel,
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.dismiss()
                        })
                builder.create()
            }
            alertDialog?.show()
            true
        }
    }

    private fun addMarker(map: GoogleMap, point: LatLng, title: String) {
        map.addMarker(
            MarkerOptions()
                .position(point)
                .title(title)
        )
        map.moveCamera(CameraUpdateFactory.newLatLng(point))
    }

}