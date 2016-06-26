package com.example.dongminshin.samplekotlin.openweather

/**
 * Created by DongMinShin on 16. 6. 26..
 */
import com.example.dongminshin.samplekotlin.openweather.domain.Forecast
import com.example.dongminshin.samplekotlin.openweather.domain.ForecastList
import com.example.dongminshin.samplekotlin.openweather.domain.ForecastResult
import com.example.dongminshin.samplekotlin.openweather.domain.ModelForecast
import java.text.DateFormat
import java.util.*

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dateFormat.format(date * 1000)
    }

}