package com.example.travelthru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var cityNames = arrayOf("hhh")
    private var cityTimeDetails = arrayOf("hhh")
    private var cityTimes = arrayOf("00:00")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.city_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cityNames.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.cityName.text = cityNames[position]
        holder.cityTimeDetail.text = cityTimeDetails[position]
        holder.cityTime.text = cityTimes[position]
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var cityName: TextView
        var cityTimeDetail: TextView
        var cityTime: TextView

        init {
            cityName = itemView.findViewById(R.id.city_name)
            cityTimeDetail = itemView.findViewById(R.id.city_time_detail)
            cityTime = itemView.findViewById(R.id.city_current_time)
        }
    }
}