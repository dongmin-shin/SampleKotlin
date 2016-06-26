package com.example.dongminshin.samplekotlin.openweather.singletone

import com.example.dongminshin.samplekotlin.openweather.domain.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by DongMinShin on 16. 6. 26..
 */

class SingletoneSample private constructor() {

    private val PROTOCOL = "http"
    private val APPID = "49c0f4d53c06fa158d6f8ffa18765695"

    private val CURRENT_WEATHER_URL = "api.openweathermap.org/data/2.5/weather"
    private val DAILY_WEATHER_URL = "api.openweathermap.org/data/2.5/forecast/daily"

    private object Holder {
        val INSTANCE = SingletoneSample()
    }

    companion object {
        val instance: SingletoneSample by lazy { Holder.INSTANCE }
    }

    fun getCurrentWeatherByCityName(city: String): String {
        val reqUrl = "${PROTOCOL}://${CURRENT_WEATHER_URL}?q=${city}&APPID=$APPID"
        return URL(reqUrl).readText()
    }

    fun getDailyWeatherByCityName(city: String): ForecastResult {
        val reqUrl = "${PROTOCOL}://${DAILY_WEATHER_URL}?q=${city}&APPID=$APPID"
        val forecastJsonStr = URL(reqUrl).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}