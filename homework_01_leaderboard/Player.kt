package edu.msudenver.leaderboard

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Homework 01 - Player
 */

/**
 * TODO: A player has the following properties: id (a String) and score (cannot be negative and it should be set to zero if not informed)
 */
class Player(id: String, score: Int = 0): Comparable<Player> {

    companion object {
        const val DEFAULT_SCORE = 0
    }

    // TODO: override toString, returning the player's id and score
    override fun toString(): String {
        return ""
    }

    override fun compareTo(other: Player): Int {
        return other.score - score
    }
}

fun main() {

    // TODO: instantiate a dynamic array of players named "leaderBoard"
    

    // TODO: add the following players into "leaderBoard"
    // SEEGAAAA, 2034
    // kon00, 111123
    // gandulaMaster, -10 (trying to set a negative score should have it default to 0)
    // diablo5342, 23945
    // LucasDiasC, 3452
    val seegaaaa      = Player("SEEGAAAA", 2034)
    val kon00         = Player("kon00", 111123)
    val gandulaMaster = Player("gandulaMaster")
    val diablo5342    = Player("diablo5342", 23945)
    val lucasDiasC    = Player("LucasDiasC", 3452 )
    

    // trying to set a player's score to a negative value should have no effect
    kon00.score = -10

    // display (sorted) leaderBoard by score in reverse order
    for (player in leaderBoard.sorted())
        println(player)
}