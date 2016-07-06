package com.example.dongminshin.samplekotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dongminshin.samplekotlin.chapter.Chapter3
import com.example.dongminshin.samplekotlin.chapter.Chapter4
import com.example.dongminshin.samplekotlin.chapter.Chapter8
import com.example.dongminshin.samplekotlin.chapter.chapter10.Chapter10
import com.example.dongminshin.samplekotlin.chapter.chapter5.Chapter5
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chapter3Button.setOnClickListener {
            val intent = Intent(applicationContext, Chapter3::class.java)
            startActivity(intent)
        }

        chapter4Button.setOnClickListener {
            val intent = Intent(applicationContext, Chapter4::class.java)
            startActivity(intent)
        }

        chapter5Button.setOnClickListener {
            var intent = Intent(applicationContext, Chapter5::class.java)
            startActivity(intent)
        }

        chapter8Button.setOnClickListener {
            var intent = Intent(applicationContext, Chapter8::class.java)
            startActivity(intent)
        }

        chapter10Button.setOnClickListener {
            var intent = Intent(applicationContext, Chapter10::class.java)
            startActivity(intent)
        }

    }

}
