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
        println("Calculate button clicked")
        val reading : String= readingInput.text.toString()
        val scale: Int = scaleInput.checkedRadioButtonId
        val scaleReading: String = resources.getResourceEntryName(scale)

        if (reading == "") {
            Toast.makeText(applicationContext,"Please input the value to convert", Toast.LENGTH_SHORT).show()
            return
        }


        println("Reading is $reading scale is $scaleReading")
    }

}
