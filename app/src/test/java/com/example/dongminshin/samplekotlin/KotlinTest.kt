package com.example.dongminshin.samplekotlin

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.junit.Test
import kotlin.test.assertEquals
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

        var name: String
        var surName: String

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
        var person = Person("Shin", "DongMin");
        println(person.toString())
        println(person.printSpecially())
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    @Test
    fun add_test() {
        var result = add(3, 5)
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
        println(RequestForecast.instance.requestForecast())
    }

    @Test
    fun async_test() {
        doAsync {
            val forecastJsonStr = RequestForecast.instance.requestForecast()
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

}