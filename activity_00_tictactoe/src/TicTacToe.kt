/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 00 - TicTacToe
 */

package edu.msudenver.tictactoe
import kotlin.random.Random

class TicTacToe(playerName: String, playerSymbol: Char = NOUGHTS) {

    companion object {
        const val NOUGHTS = 'O'
        const val CROSSES = 'X'
        const val BLANK   = ' '
        const val BOARD_SIZE = 3
    }

    // TODOd: define "playerName" as a property
    var playerName = playerName
        get() = field // optional
        set(value) { field = value } // optional

    // TODOd: define "playerSymbol as a property; validate "playerSymbol", making NOUGHTS as default
    var playerSymbol = if (playerSymbol != NOUGHTS && playerSymbol != CROSSES) NOUGHTS else playerSymbol
        set(value) { field = if (value != NOUGHTS && value != CROSSES) field else value }

    // TODOd: define a "board" member variable (private) as a 2D char array of BOARD_SIZE x BOARD_SIZE
    // initialize it with BLANKs
    var board = Array(
        BOARD_SIZE,
        { Array(
                BOARD_SIZE,
                {
                    BLANK
                }
            )
        }
    )

    // another way
    var boardv2 = Array(
        BOARD_SIZE
    ) {
        Array(
            BOARD_SIZE
        ) {
            BLANK
        }
    }

    // another way
    var boardv3 = Array(
        BOARD_SIZE
    ) { _ ->
        Array(
            BOARD_SIZE
        ) { _ ->
            BLANK
        }
    }

    /**
     * If there is a row with the same symbol, return the symbol; BLANK otherwise
     * @return symbol
     */
    private fun rowWin(): Char {
        for (i in 0 until BOARD_SIZE) {
            val symbol = board[i][0]
            if (symbol == BLANK)
                continue
            var found = true
            for (j in 0 until BOARD_SIZE)
                if (symbol != board[i][j]) {
                    found = false
                    break
                }
            if (found)
                return symbol
        }
        return BLANK
    }

    /**
     * TODOd: If there is a column with the same symbol, return the symbol; BLANK otherwise
     * @return symbol
     */
    private fun colWin(): Char {
        for (j in 0 until BOARD_SIZE) {
            val symbol = board[0][j]
            if (symbol == BLANK)
                continue
            var found = true
            for (i in 0 until BOARD_SIZE)
                if (symbol != board[i][j]) {
                    found = false
                    break
                }
            if (found)
                return symbol
        }
        return BLANK
    }

    /**
     * If there is a diagonal with the same symbol, return the symbol; BLANK otherwise
     * @return symbol
     */
    private fun diagonalWin(): Char {
        var symbol = board[0][0]
        if (symbol != BLANK) {
            var found = true
            for (i in 1 until BOARD_SIZE)
                if (symbol != board[i][i]) {
                    found = false
                    break
                }
            if (found)
                return symbol
        }
        symbol = board[0][BOARD_SIZE - 1]
        if (symbol != BLANK) {
            var found = true
            for (i in 1 until BOARD_SIZE)
                if (symbol != board[i][BOARD_SIZE - i - 1]) {
                    found = false
                    break
                }
            if (found)
                return symbol
        }
        return BLANK
    }

    /**
     * TODOd: if there is a winner, return its symbol; BLANK otherwise
     * @return symbol
     */
    fun getWinner(): Char {
        var winner = rowWin()
        if (winner != BLANK)
            return winner
        winner = colWin()
        if (winner != BLANK)
            return winner
        winner = diagonalWin()
        return winner
    }

    /**
     * Return true/false if there is at least an EMPTY symbol on the board
     * @return boolean
     */
    private fun canMove(): Boolean {
        for (i in 0 until BOARD_SIZE)
            for (j in 0 until BOARD_SIZE)
                if (board[i][j] == BLANK)
                    return true
        return false
    }

    /**
     * Return true/false if the game is over
     * @return
     */
    fun isGameOver(): Boolean {
        val winner = getWinner()
        if (winner != BLANK)
            return true
        return !canMove()
    }

    /**
     * Allow the player to play a move (if the move is valid)
     * @param i row coordinate
     * @param j column coordinate
     * @return true/false depending on whether the move was valid
     */
    fun playerPlay(i: Int, j: Int): Boolean {
        if (board[i][j] == BLANK) {
            board[i][j] = playerSymbol;
            return true;
        }
        return false;
    }

    /**
     * Return the computer's symbol
     * @return
     */
    fun getComputerSymbol(): Char {
        return if (playerSymbol === NOUGHTS) CROSSES else NOUGHTS
    }

    /**
     * Allow the computer to play a random move (no AI this time)
     * @return true/false depending on whether the move was possible
     */
    fun computerPlay(): Boolean {
        if (canMove()) {
            while (true) {
                val i: Int = Random.nextInt(BOARD_SIZE)
                val j: Int = Random.nextInt(BOARD_SIZE)
                if (board[i][j] === BLANK) {
                    board[i][j] = getComputerSymbol()
                    return true
                }
            }
        }
        return false
    }

    /**
     * Return a string representation of the board
     */
    override fun toString(): String {
        var s = ""
        for (i in 0 until BOARD_SIZE) {
            for (j in 0 until BOARD_SIZE) {
                if (board[i][j] == BLANK)
                    s += " - "
                else
                    s += " " + board[i][j] + " "
                s += "\t"
            }
            s += "\n"
        }
        return s
    }
}

/**
 * TODO: implement a simple round of the game
 */
fun main() {
    print("name? ")
    val playerName = readLine() ?: return
    val ticTacToe = TicTacToe(playerName)
    while (!ticTacToe.isGameOver()) {
        println(ticTacToe)
        print("move? ")
        val move = readLine() ?: continue
        val coordinates = move.split(",")
        val i = Integer.valueOf(coordinates[0])
        val j = Integer.valueOf(coordinates[1])
        ticTacToe.playerPlay(i, j)
        if (!ticTacToe.isGameOver()) {
            ticTacToe.computerPlay()
        }
    }
    println(ticTacToe)
    val winner = ticTacToe.getWinner()
    if (winner == ticTacToe.playerSymbol) {
        println("Congratulations ${ticTacToe.playerName}!")
    }
    else if (winner == ticTacToe.getComputerSymbol()) {
        println("Computers are superior! I won!!!")
    }
    else {
        println("Tie!!!")
    }
}