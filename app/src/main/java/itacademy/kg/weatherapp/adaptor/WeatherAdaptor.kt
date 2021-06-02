package itacademy.kg.weatherapp.adaptor

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import itacademy.kg.weatherapp.R
import itacademy.kg.weatherapp.model.Weather

class WeatherAdaptor (weatherList:List<Weather>) : RecyclerView.Adapter<WeatherAdaptor.WeatherHolder>() {

    inner class WeatherHolder(itamView:View) :RecyclerView.ViewHolder(itamView) {
        val cities =itamView.findViewById<TextView>(R.id.city_itam)
        val longtit = itamView.findViewById<TextView>(R.id.longtit_itam)
        val latit = itamView.findViewById<TextView>(R.id.latit_itam)
        val temparatur = itamView.findViewById<TextView>(R.id.temp_fact_itam)
        val feelsLike = itamView.findViewById<TextView>(R.id.temp_feel_itam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_itam,parent,false)
        return WeatherHolder(view)
    }

    val list = weatherList

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.itemView.apply {
            val count = list[position]
            holder.cities.text = count.city
            holder.longtit.text = count.longitude.toString()
            holder.latit.text = count.latitude.toString()
            holder.temparatur.text = count.temparature.toString()
            holder.feelsLike.text = count.feelsLike.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}