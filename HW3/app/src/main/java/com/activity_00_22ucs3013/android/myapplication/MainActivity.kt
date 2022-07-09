//package edu.msudenver.number_guessing // remove comment when grading
package com.activity_00_22ucs3013.android.myapplication // comment out when grading

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Homework 03 - NumberGuessing and MainActivity
 */

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


// model
class NumberGuessing {

    private var number = Random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER
    private var guesses = mutableListOf<Int>()
    var attempts = 0
    private var guessed = false

    companion object {
        const val GAME_OVER        = 0
        const val INVALID_GUESS    = 1
        const val ALREADY_GUESSED  = 2
        const val GUESSED_TOO_LOW  = 3
        const val GUESSED_TOO_HIGH = 4;
        const val MIN_NUMBER       = 1
        const val MAX_NUMBER       = 100
    }

    fun attempt(number: Int): Int {
        if (guessed)
            return GAME_OVER
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            return INVALID_GUESS
        if (number in guesses)
            return ALREADY_GUESSED
        guesses.add(number)
        attempts++
        if (number > this.number)
            return GUESSED_TOO_HIGH
        if (number < this.number)
            return GUESSED_TOO_LOW
        guessed = true
        return GAME_OVER
    }

    fun reset() {
        number = Random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER
        attempts = 0
        guessed = false
        guesses = mutableListOf<Int>()
    }
}

class MainActivity : AppCompatActivity() {

    var numberGuessing = NumberGuessing()
    //val editText: EditText = findViewById(R.id.edtNumber) // this was giving me problems and crashing the app.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: get a reference to the "go" Button and to the "edtNumber" EditText
        val btnGo: Button = findViewById(R.id.btnGo)
        val editText: EditText = findViewById(R.id.edtNumber)

        btnGo.setOnClickListener {
            // TODO #2: extract the number from the "edtNumber" EditText
            val num = Integer.valueOf(editText.text.toString())

            // TODO #3: show a Toast with an appropriate message depending on the result of the user's attempt
            // if the user guessed right, show a Toast with a message displaying "Number X guessed after Y attempts!" substituting X and Y accordingly; reset the game
            val outcome = numberGuessing.attempt(num)

            val dictionary = mapOf(
                0 to "Number ${num} guessed after ${numberGuessing.attempts} attempts!\nGAME OVER!\n",
                1 to "Number ${num} is a invalid guess; try again!\n",
                2 to "Number ${num} has already been guessed; try again!\\n",
                3 to "Number ${num} is too low; try again!\n",
                4 to "Number ${num} is too high; try again!\n"
            )

            fun toastDisplay(key:Int){
                val myToast =  Toast.makeText(
                    this,
                    "${dictionary[key]}",
                    Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.TOP,0,200)
                myToast.show()
            }

            when (outcome){
                0 -> toastDisplay(0)
                1 -> toastDisplay(1)
                2 -> toastDisplay(2)
                3 -> toastDisplay(3)
                4 -> toastDisplay(4)
            }
            // TODO #4: prepare the next round by clearing the text
            if(outcome == 0){
             //if(numberGuessing.equals(GAME_OVER)){ //This does not work
             //if(numberGuessing.GAME_OVER){ //This does not work
                numberGuessing.reset()
                editText.setText("")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        val editText: EditText = findViewById(R.id.edtNumber)
        val number = Integer.valueOf(editText.text.toString())
        outState.putInt("number", number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        val editText: EditText = findViewById(R.id.edtNumber)
        editText.setText(savedInstanceState.getInt("number").toString() ?: "")
    }
}