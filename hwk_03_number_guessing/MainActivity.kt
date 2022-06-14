package edu.msudenver.number_guessing

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Homework 03 - NumberGuessing and MainActivity
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: get a reference to the "go" Button and to the "edtNumber" EditText
        val btnGo = null
        val editText = null

        btnGo.setOnClickListener {
            // TODO #2: extract the number from the "edtNumber" EditText

            // TODO #3: show a Toast with an appropriate message depending on the result of the user's attempt
            // if the user guessed right, show a Toast with a message displaying "Number X guessed after Y attempts!" substituting X and Y accordingly; reset the game
            
            // TODO #4: prepare the next round by clearing the text
        }
    }
}