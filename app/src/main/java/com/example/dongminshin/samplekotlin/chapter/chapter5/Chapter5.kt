package com.example.dongminshin.samplekotlin.chapter.chapter5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.dongminshin.samplekotlin.chapter.chapter5.Chapter5ForecastListAdapter
import com.example.dongminshin.samplekotlin.R
import kotlinx.android.synthetic.main.activity_chapter5.*

class Chapter5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter5)

        forecast_list.layoutManager = LinearLayoutManager(this)
        forecast_list.adapter = Chapter5ForecastListAdapter(getForecastItemList())
    }

    fun getForecastItemList(): List<String> {
        return listOf<String>(
                "Mon 6/23 - Sunny - 31/17",
                "Tue 6/24 - Foggy - 21/8",
                "Wed 6/25 - Cloudy - 22/17",
                "Thurs 6/26 - Rainy - 18/11",
                "Fri 6/27 - Foggy - 21/10",
                "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                "Sun 6/29 - Sunny - 20/7"
        )
    }
}
