package com.example.dongminshin.samplekotlin

import com.example.dongminshin.samplekotlin.openweather.RequestForecastCommand
import com.example.dongminshin.samplekotlin.openweather.singletone.SingletoneSample
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

/**
 * Created by DongMinShin on 16. 6. 22..
 */

class KotlinTest {

    open class Animal() {
        open fun printSpecially(): String {
            return "Specially"
        }
    }

    class Person(name: String, surName: String) : Animal() {

        val name: String
        val surName: String

        init {
            this.name = name
            this.surName = surName
        }

        override fun toString(): String {
            return name + surName
        }

        override fun printSpecially(): String {
            return "Child" + super.printSpecially()
        }
    }

    @Test
    fun sample_test() {
        assertTrue { true }
    }

    @Test
    fun person_class_test() {
        val person = Person("Shin", "DongMin");

        println(person.toString())
        println(person.printSpecially())
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    @Test
    fun add_test() {
        val result = add(3, 5)
        println(result)
    }

    @Test
    fun variable_test() {
        // var is muable, so can assign value
        var a = 3
        a = 5

        assertEquals(a, 5)

        // val is immutable, so if assign value, see error
//        val b = 10
//        b = 15
    }

    @Test
    fun no_automatic_type_cast_test() {
        // Integer to double test
        val i: Int = 7
        val d: Double = i.toDouble()

        assertTrue(d is Double)  // Type check
        assertEquals(d, 7.0)    // Value check

        // Chatacter to integer test
        val charValue: Char = 'c'
        val intValue: Int = charValue.toInt()

        assertTrue(intValue is Int)
        assertEquals(intValue, 99)
    }

    @Test
    fun bitwise_test() {
        val FLAG1: Boolean = true
        val FLAG2: Boolean = false

        val bitwiseAND = FLAG1 and FLAG2
        val bitwiseOR = FLAG1 or FLAG2

        assertEquals(bitwiseAND, false)
        assertEquals(bitwiseOR, true)
    }

    @Test
    fun infer_type_test() {
        val i = 12
        val iHex = 0x0f
        val l = 3L
        val d = 3.5
        val f = 3.5F
        val s = "Example"

        assertTrue(i is Int)

        assertTrue(iHex is Int)
        assertEquals(iHex, 15)

        assertTrue(l is Long)
        assertTrue(d is Double)
        assertTrue(f is Float)
        assertTrue(s is String)
    }

    @Test
    fun string_iterator_test() {
        val s = "Example"
        for (c in s) {
            println(c)
        }
    }

    @Test
    fun url_test() {
        println(SingletoneSample.instance.getCurrentWeatherByCityName("Seoul"))
    }

    @Test
    fun async_test() {
        doAsync {
            val forecastJsonStr = SingletoneSample.instance.getCurrentWeatherByCityName("Seoul")
            uiThread {
                println(forecastJsonStr)
            }
        }
    }

    class Cow() {
        var name: String = ""
            get() = field.toUpperCase()
            set(value) {
                field = "Name: $value"
            }
    }

    @Test
    fun class_modify_setter_getter_test() {
        val cow = Cow()
        cow.name = "Crazy Cow"
        println(cow.name)
    }

    data class Forecast(val date: Date, val temperature: Float, val details: String)

    @Test
    fun data_class_copy_test() {
        val forecast_one = Forecast(Date(), 27.5f, "Shiny day")
        val forecast_two = forecast_one.copy(temperature = 30f)

        assertNotEquals(forecast_one, forecast_two)
        println("One(${forecast_one.toString()}),\nTwo(${forecast_two.toString()})")
    }

    @Test
    fun data_calss_multi_declaration_test() {
        val forecast = Forecast(Date(), 32f, "Hot day")
        val (a, b) = forecast
        println("$a : $b")

        val (date_m, temperature_m, details_m) = forecast
        println("$date_m : $details_m ($temperature_m)")

        val date1 = forecast.component1()
        val temperature1 = forecast.component2()
        val details1 = forecast.component3()

        assertEquals(date_m, date1)
        assertEquals(temperature_m, temperature1)
        assertEquals(details_m, details1)
    }

    @Test
    fun map_multi_declaration_test() {
        val testMap = HashMap<Int, String>()
        testMap.put(1, "Hello")
        testMap.put(2, "Kotlin")

        for ((key, value) in testMap) {
            println("$key : $value")
        }
    }

    @Test
    fun request_5_day_weather_test() {
        val forecastResult = SingletoneSample.instance.getDailyWeatherByCityName("Seoul")
        println(forecastResult)
    }

    @Test
    fun request_forecast_command_test() {
        val predict5dayForecast = RequestForecastCommand("Seoul").execute()
        val forecastList = predict5dayForecast.list

        for (modelForecast in forecastList) {
            println("${modelForecast.dt} : ${modelForecast.description}(${modelForecast.minTemp}/${modelForecast.maxTemp})")
        }
    }

    interface KotlinInterface {
        fun execute()
        fun printHello() {
            println("Hello${KotlinInterface::class.java}")
        }
    }

    class KotlinImplementTest() : KotlinInterface {
        override fun execute() {
            println("Execute${KotlinImplementTest::class.java}")
        }
    }

    @Test
    fun kotlin_interface_test() {
        val test = KotlinImplementTest()
        test.execute()
        test.printHello()
    }

}