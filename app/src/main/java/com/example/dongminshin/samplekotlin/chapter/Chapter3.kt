package com.example.dongminshin.samplekotlin.chapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dongminshin.samplekotlin.R
import kotlinx.android.synthetic.main.activity_chapter4.*

class Chapter3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter3)

        message.text = "Hello Kotlin"
    }

}
