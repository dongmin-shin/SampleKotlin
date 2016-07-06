package com.example.dongminshin.samplekotlin

import org.junit.Test

/**
 * Created by DongMinShin on 16. 7. 6..
 */
class Chapter4Test {

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    @Test
    fun add_test() {
        val result = add(3, 5)
        println(result)
    }

}