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

    // TODO: define "playerName" as a property
    var playerName = playerName
        get() = field //optional return of field. we would actually write a getter if we have some condition or expression based on other variables.
        set(value) { field = value } // also optional

    // TODO: define "playerSymbol as a property; validate "playerSymbol", making NOUGHTS as default
    var playerSymbol = if (playerSymbol != NOUGHTS && playerSymbol != CROSSES) NOUGHTS else playerSymbol
        set(value) { field = if (playerSymbol != NOUGHTS && playerSymbol != CROSSES) NOUGHTS else value}

    // TODO: define a "board" member variable (private) as a 2D char array of BOARD_SIZE x BOARD_SIZE
    // initialize it with BLANKs
    //var board = Array<Char>(BOARD_SIZE, { _ -> Array<Char>(BOARD_SIZE,{ _ -> ' '})})
    var board = Array(BOARD_SIZE,{
            Array(BOARD_SIZE,{
                    BLANK
                }
            )
        }
    )
    // another way
/*    var boardv2 = Array(BOARD_SIZE,{Array(BOARD_SIZE, BLANK})
*/
    /*
    var boardV3 =
*/
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
     * TODO: If there is a column with the same symbol, return the symbol; BLANK otherwise
     * @return symbol
     */
    private fun colWin(): Char {
        for (j in 0 until BOARD_SIZE){
            val symbol = board[0][j]
            if (symbol == BLANK)
                continue
            var found = true
            for (i in 0 until BOARD_SIZE)
                if (symbol != board[i][j]){
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
     * TODO: if there is a winner, return its symbol; BLANK otherwise
     * @return symbol
     */
    fun getWinner(): Char {
        var winner = rowWin()
        if (winner != BLANK)
            return winner
        //too fast missed the solution. :( I think this is right
        winner = colWin()
        if(winner != BLANK)
            return winner
        return BLANK
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
    //Challenge TODO: this allows a player to change symbol in the middle of the game, this should be fixed
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
 * ask user for name
 * initialize tictactoe object
 * loop while not game over
 * ask player for move
 * when game over show who won the game.
 */
fun main() {
    println("Enter player 1 name\n")
    var name = String.valueOf(readLine())
    println("Enter player Symbol\n")
    var symbol = Char.valueOf(readLine())
    val game = TicTacToe(name, symbol)
    while(game.is)
    
}