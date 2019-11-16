package com.liyosi.tempconverter

import android.os.Bundle
import android.text.Editable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        aboutBtn.setOnClickListener {
            onAboutBtnClicked(it)
        }

        calculateBtn.setOnClickListener {
            onCalculateBtnClicked(it)
        }
    }

    private fun onAboutBtnClicked(btn: View) {
        println("About button clicked")
    }

    private fun onCalculateBtnClicked(btn: View) {
        val reading : String= readingInput.text.toString()
        val scale: Int = scaleInput.checkedRadioButtonId
        val scaleReading: String = resources.getResourceEntryName(scaleInput.checkedRadioButtonId)

        if (reading == "") {
            Toast.makeText(applicationContext,"Please input the value to convert", Toast.LENGTH_SHORT).show()
            return
        }

        val convertedValue = if (scale == R.id.celsius) toFahrenheit(reading.toDouble()) else toCelicus(reading.toDouble())
        readingInput.setText(convertedValue.toString())
    }

    private fun toFahrenheit(celcius: Double): Double {
        // Multiply by 9, then divide by 5, then add 32
        println("Converting $celcius to fahrenheit ")
        return ((9.times(celcius) ) / 5.0 ) + 32.0
    }

    private fun toCelicus(fahrenheit: Double): Double {
        // Deduct 32, then multiply by 5, then divide by 9
        println("Converting $fahrenheit to celcius")
        return ((fahrenheit - 32) * 5 ) / 9
    }

}
