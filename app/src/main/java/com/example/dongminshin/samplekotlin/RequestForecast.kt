package com.example.dongminshin.samplekotlin

import java.net.URL

/**
 * Created by DongMinShin on 16. 6. 26..
 */

class RequestForecast private constructor() {

    private object Holder {
        val INSTANCE = RequestForecast()
    }

    companion object {
        val instance: RequestForecast by lazy { Holder.INSTANCE }
    }

    fun requestForecast(): String {
        val protocol = "http"
        val appId = "49c0f4d53c06fa158d6f8ffa18765695"
        val city = "Seoul"
        val url = "api.openweathermap.org/data/2.5/weather?q="
        val reqUrl = "${protocol}://${url}${city}&APPID=$appId"

        return URL(reqUrl).readText()
    }
}