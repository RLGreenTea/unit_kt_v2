package com.rl.unit_kt_v2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var echo: TextView
    private lateinit var inputA: EditText
    private lateinit var inputB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        echo = findViewById(R.id.echo)
        inputA = findViewById(R.id.inputA)
        inputB = findViewById(R.id.inputB)
    }

    private fun vibrate() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(60)
    }

    fun convert(view: View) {
        try {
            val a: Int = inputA.text.toString().toInt()
            val b: Int = inputB.text.toString().toInt()
            val result: Double = a * b * 0.3025 / 10000
            echo.text = if (result >= 0.001) result.toString() else "數值過小"
            vibrate()
        } catch(e: NumberFormatException) {
            echo.text = "格式錯誤"
        }
    }

    fun clear(view: View) {
        inputA.text = null
        inputB.text = null
        echo.text = "[ 坪數 ]"
        vibrate()
    }
}