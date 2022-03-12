package com.example.travelthru

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val cities: ArrayList<CityTimeCard>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var cityName: TextView
        var cityTimeDetail: TextView
        var cityTime: TextView
        init {
            cityName = view.findViewById(R.id.city_name)
            cityTimeDetail = view.findViewById(R.id.city_time_detail)
            cityTime = view.findViewById(R.id.city_current_time)

            view.setOnClickListener {
                val intent = Intent(it.context, ConverterActivity::class.java)
                intent.putExtra("position", adapterPosition)
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.city_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text = cities[position].getCityName()
        holder.cityTimeDetail.text = cities[position].getCityTimeDetail()
        holder.cityTime.text = cities[position].getCityTime()
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}