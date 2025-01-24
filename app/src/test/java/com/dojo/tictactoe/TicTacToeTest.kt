package com.dojo.tictactoe

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TicTacToeTest {
    @Test
    fun `Start with player X`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        val currentPlayer = ticTacToeGame.getCurrentPlayer()

        // Then
        assertEquals(Player.X, currentPlayer)
    }

    @Test
    fun `Second player should be O`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play()

        // Then
        assertEquals(Player.O, ticTacToeGame.getCurrentPlayer())
    }

    @Test
    fun `Make the players switch`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play()
        ticTacToeGame.play()

        // Then
        assertEquals(Player.X, ticTacToeGame.getCurrentPlayer())
    }
}