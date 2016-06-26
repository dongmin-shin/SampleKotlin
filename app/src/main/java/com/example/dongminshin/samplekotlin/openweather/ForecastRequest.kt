package com.example.dongminshin.samplekotlin.openweather

import com.example.dongminshin.samplekotlin.Command
import com.example.dongminshin.samplekotlin.openweather.domain.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by DongMinShin on 16. 6. 26..
 */
class ForecastRequest(val city: String) : Command<ForecastResult> {

    private val PROTOCOL = "http"
    private val APPID = "49c0f4d53c06fa158d6f8ffa18765695"
    private val UNITS = "metric"
    private val DAILY_WEATHER_URL = "api.openweathermap.org/data/2.5/forecast/daily"

    override fun execute(): ForecastResult {
        val reqUrl = "${PROTOCOL}://${DAILY_WEATHER_URL}?q=${city}&units=$UNITS&APPID=$APPID"
        val forecastJsonStr = URL(reqUrl).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}