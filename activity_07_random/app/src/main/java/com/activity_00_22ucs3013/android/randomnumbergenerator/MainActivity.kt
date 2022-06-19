//package edu.msudenver.randomnumbergenerator
package com.activity_00_22ucs3013.android.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //private lateinit var text: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: get a reference to the textview
        //text = findViewbyId(R.id.)
        var txtRandomNumber: TextView = findViewById(R.id.txtRandomNumber)

        // TODO: write the for the "onClickListener"
        // 1a get a reference to the edittext "from"
        // 1b extract the "from" integer value
        // 2a get a reference to the edittext "to"
        // 2b extract the "to" integer value
        // 3 generate a random number in "from" until "to" + 1
        // 4 update the textview
        
    }
}
