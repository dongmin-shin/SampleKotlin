package com.example.dongminshin.samplekotlin.openweather

import com.example.dongminshin.samplekotlin.Command
import com.example.dongminshin.samplekotlin.openweather.ForecastDataMapper
import com.example.dongminshin.samplekotlin.openweather.ForecastRequest
import com.example.dongminshin.samplekotlin.openweather.domain.ForecastList

/**
 * Created by DongMinShin on 16. 6. 26..
 */
class RequestForecastCommand(val city: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(city)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}