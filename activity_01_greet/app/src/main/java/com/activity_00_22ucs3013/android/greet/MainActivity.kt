//package edu.msudenver.greet
package com.activity_00_22ucs3013.android.greet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // NOTE: following variable declaration statements were added
    private lateinit var nameText: EditText
    private lateinit var greetButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // NOTE: following statements were added
        nameText = findViewById(R.id.name_text)
        greetButton = findViewById(R.id.greet_button)
        greetButton.setOnClickListener {
            view: View ->
            Toast.makeText(this, "Hello " + nameText.text + "!", Toast.LENGTH_LONG).show()
        }
    }
}