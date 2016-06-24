package com.example.dongminshin.samplekotlin.chapter4

import org.junit.Test
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

    fun print(message: String) {
        System.out.println(message)
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

}