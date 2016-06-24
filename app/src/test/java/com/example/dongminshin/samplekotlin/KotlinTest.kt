package com.example.dongminshin.samplekotlin

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
        print(person.toString())
        print(person.printSpecially())
    }

    @Test
    fun add_test() {
        var result = add(3, 5)
        print(result)
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

    fun print(message: String) {
        System.out.println(message)
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

}