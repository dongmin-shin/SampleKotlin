package com.example.dongminshin.samplekotlin.chapter.chapter10

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.dongminshin.samplekotlin.openweather.domain.ForecastList

/**
 * Created by DongMinShin on 16. 6. 26..
 */
class Chapter10ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<Chapter10ForecastListAdapter.Chapter10ViewHolder>() {

    override fun onBindViewHolder(holder: Chapter10ViewHolder, position: Int) {
        // Typically
//        val weekForecast = weekForecast.list.get(position)
//        holder.textView.text = "${weekForecast.dt} - ${weekForecast.description} - ${weekForecast.maxTemp}/${weekForecast.minTemp}"

        // Using 'with' keyword
        with(weekForecast.list.get(position)) {
            holder.textView.text = "$dt - $description - $maxTemp/$minTemp"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chapter10ViewHolder? {
        return Chapter10ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.list.size
    }

    class Chapter10ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}