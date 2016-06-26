package com.example.dongminshin.samplekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.util.concurrent.Executors

class Chapter8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter8)

        // Default async
//        doAsync {
//            val forecastJsonStr = RequestForecast.instance.requestForecast()
//            uiThread { longToast(forecastJsonStr) }
//        }

        // Async with Java executor
        val executor = Executors.newScheduledThreadPool(4)
        doAsync(executorService = executor) {
            val forecastJsonStr = RequestForecast.instance.requestForecast()
            uiThread { longToast(forecastJsonStr) }
        }

    }
}
