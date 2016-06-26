package com.example.dongminshin.samplekotlin

/**
 * Created by DongMinShin on 16. 6. 26..
 */
interface Command<T> {
    fun execute(): T
}