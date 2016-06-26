package com.example.dongminshin.samplekotlin.chapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.dongminshin.samplekotlin.MainActivity
import com.example.dongminshin.samplekotlin.R
import kotlinx.android.synthetic.main.activity_chapter4.*

class Chapter4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4)

        message.text = "Hello Kotlin"

        // Chapter4 example
        // 메소드 오버로딩시 파라메터의 기본 값을 지정할 수 있어서, 복잡한 오버로드 코드를 제거할 수 있다.
//        toast(message.text.toString())
//        toast(message.text.toString(), Toast.LENGTH_LONG)

//        niceToast(message.text.toString())
//        niceToast(message.text.toString(), "MyTag")
//        niceToast(message.text.toString(), "MyTag", Toast.LENGTH_LONG)

        // 메소드 파라메터의 위치와 상관 없이 직접 파라메터 이름을 지정하여 사용할 수 있다.
//        niceToast(length = Toast.LENGTH_LONG, message = "Oh My God!!", tag = "OMG Tag")
//        niceToast(length = Toast.LENGTH_LONG, message = testString(), tag = "OMG Tag")

        niceBitMoreToast(message);
    }

    private fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show();
    }

    private fun niceToast(message: String,
                          tag: String = MainActivity::class.java.simpleName,
                          length: Int = Toast.LENGTH_SHORT) {

        // Before
//        Toast.makeText(this, "[" + tag + "] " + message, length).show()

        // After (adopt String template)
        Toast.makeText(this, "[$tag] $message", length).show()
    }

    private fun niceBitMoreToast(message: TextView, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "${message.text}", length).show()
    }

    private fun testString(): String {
        return "Omg brexit..."
    }
}
