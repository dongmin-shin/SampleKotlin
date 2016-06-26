package com.example.dongminshin.samplekotlin.chapter.chapter5

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by DongMinShin on 16. 6. 24..
 */
class Chapter5ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<Chapter5ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}