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
        ticTacToeGame.play(Cell.MiddleCenter)

        // Then
        assertEquals(Player.O, ticTacToeGame.getCurrentPlayer())
    }

    @Test
    fun `Make the players switch`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.MiddleCenter)

        // Then
        assertEquals(Player.X, ticTacToeGame.getCurrentPlayer())
    }

    @Test
    fun `Make X win on left column`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.MiddleLeft)
        ticTacToeGame.play(Cell.BottomRight)
        ticTacToeGame.play(Cell.BottomLeft)

        // Then
        assertEquals(Player.X, ticTacToeGame.getWinner())
    }
}