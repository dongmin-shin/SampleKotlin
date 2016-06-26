package com.example.dongminshin.samplekotlin.chapter.chapter10

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.dongminshin.samplekotlin.R
import com.example.dongminshin.samplekotlin.openweather.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_chapter10.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Chapter10 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter10)

        recycler_view.layoutManager = LinearLayoutManager(this)

        doAsync {
            val forecastList = RequestForecastCommand("Seoul").execute()
            uiThread {
                recycler_view.adapter = Chapter10ForecastListAdapter(forecastList)
            }
        }

    }
}
