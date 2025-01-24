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

    @Test
    fun `Make X win on central column`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopCenter)
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.BottomRight)
        ticTacToeGame.play(Cell.BottomCenter)

        // Then
        assertEquals(Player.X, ticTacToeGame.getWinner())
    }

    @Test
    fun `Make X win on right column`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopRight)
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.MiddleRight)
        ticTacToeGame.play(Cell.BottomLeft)
        ticTacToeGame.play(Cell.BottomRight)

        // Then
        assertEquals(Player.X, ticTacToeGame.getWinner())
    }

    @Test
    fun `Make no winner at the start`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        val winner = ticTacToeGame.getWinner()

        // Then
        assertEquals(Player.None, winner)
    }

    @Test
    fun `Make O win on top horizontal line`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.MiddleLeft)
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.BottomRight)
        ticTacToeGame.play(Cell.TopCenter)
        ticTacToeGame.play(Cell.BottomLeft)
        ticTacToeGame.play(Cell.TopRight)


        // Then
        assertEquals(Player.O, ticTacToeGame.getWinner())
    }

    @Test
    fun `Make O win on middle horizontal line`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.MiddleLeft)
        ticTacToeGame.play(Cell.TopRight)
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.BottomLeft)
        ticTacToeGame.play(Cell.MiddleRight)


        // Then
        assertEquals(Player.O, ticTacToeGame.getWinner())
    }

    @Test
    fun `Make X win on diagonal line`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.MiddleLeft)
        ticTacToeGame.play(Cell.MiddleCenter)
        ticTacToeGame.play(Cell.BottomLeft)
        ticTacToeGame.play(Cell.BottomRight)

        // Then
        assertEquals(Player.X, ticTacToeGame.getWinner())
    }

    @Test
    fun `Make the game finish with a draw`() {
        // Given
        val ticTacToeGame = TicTacToeGame()

        // When
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.TopCenter)
        ticTacToeGame.play(Cell.TopLeft)
        ticTacToeGame.play(Cell.MiddleLeft)
        ticTacToeGame.play(Cell.MiddleRight)
        ticTacToeGame.play(Cell.BottomLeft)
        ticTacToeGame.play(Cell.BottomCenter)
        ticTacToeGame.play(Cell.BottomRight)

        // Then
        assertEquals(Player.None, ticTacToeGame.getWinner())
    }
}