package com.example.dongminshin.samplekotlin.openweather.domain

/**
 * Created by DongMinShin on 16. 6. 26..
 */
data class ForecastResult(val city: City, val list: List<Forecast>)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)

data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int, val weather: List<Weather>, val speed: Float, val deg: Float, val rain: Float)

data class Coordinates(val lon: Float, val lat: Float)

data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)

data class ForecastList(val cityName: String, val county: String, val list: List<ModelForecast>)

data class ModelForecast(val dt: String, val description: String, val maxTemp: Int, val minTemp: Int)