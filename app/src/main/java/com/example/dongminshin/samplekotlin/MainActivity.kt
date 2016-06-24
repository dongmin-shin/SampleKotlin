package com.example.dongminshin.samplekotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chapter4Button.setOnClickListener {
            val intent = Intent(applicationContext, Chapter4::class.java)
            startActivity(intent)
        }

    }

}
