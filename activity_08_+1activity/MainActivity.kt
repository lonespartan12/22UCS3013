package edu.msudenver.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGo: Button = findViewById(R.id.btnGo)
        // TODO: write the code that starts a new activity depending on the radio button that was checked
        btnGo.setOnClickListener {
            
        }
    }
}

