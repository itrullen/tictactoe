package com.dojo.tictactoe

class TicTacToeGame {
    private var currentPlayer = Player.X
    private var board = Array(9) { Player.None }

    private val winnerCombinations: List<Array<Cell>> = listOf(
        arrayOf(Cell.TopLeft, Cell.MiddleLeft, Cell.BottomLeft),
        arrayOf(Cell.TopCenter, Cell.MiddleCenter, Cell.BottomCenter),
        arrayOf(Cell.TopRight, Cell.MiddleRight, Cell.BottomRight),
        arrayOf(Cell.MiddleLeft, Cell.MiddleCenter, Cell.MiddleRight),
        arrayOf(Cell.TopLeft, Cell.MiddleCenter, Cell.BottomRight),
    )

    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun play(position: Cell) {
        board[position.ordinal] = currentPlayer
        switchPlayers()
    }

    fun getWinner(): Player {
        winnerCombinations.forEach { combination ->
            if (board[combination[0].ordinal] == board[combination[1].ordinal]
                && board[combination[1].ordinal] == board[combination[2].ordinal]
            ) {
                // There is a winner
                return board[combination[0].ordinal]
            }
        }
        // There is no winner
        return Player.None
    }

    private fun switchPlayers() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }

}
