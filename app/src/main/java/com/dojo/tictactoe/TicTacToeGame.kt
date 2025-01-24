package com.dojo.tictactoe

class TicTacToeGame {
    private var currentPlayer = Player.X
    private var board = Array(9) { Player.None }

    private val winnerCombinations: List<Array<Cell>> = listOf(
        arrayOf(Cell.TopLeft, Cell.MiddleLeft, Cell.BottomLeft),
        arrayOf(Cell.TopCenter, Cell.MiddleCenter, Cell.BottomCenter),
        arrayOf(Cell.TopRight, Cell.MiddleRight, Cell.BottomRight),

        arrayOf(Cell.TopLeft, Cell.TopCenter, Cell.TopRight),
        arrayOf(Cell.MiddleLeft, Cell.MiddleCenter, Cell.MiddleRight),
        arrayOf(Cell.BottomLeft, Cell.BottomCenter, Cell.BottomRight),

        arrayOf(Cell.TopLeft, Cell.MiddleCenter, Cell.BottomRight),
        arrayOf(Cell.TopRight, Cell.MiddleCenter, Cell.BottomLeft),
    )

    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun play(position: Cell) {
        println("PLAYER $currentPlayer:")

        board[position.ordinal] = currentPlayer
        switchPlayers()
        printBoard()
    }

    fun getWinner(): Player {
        var winner = Player.None

        winnerCombinations.forEach { (first, second, third) ->
            if (board[first.ordinal] == board[second.ordinal]
                && board[second.ordinal] == board[third.ordinal]
            ) {
                winner = board[first.ordinal]
            }
        }

        printWinner(winner)

        return winner
    }

    private fun switchPlayers() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }

    private fun printBoard() {
        board.map { if (it == Player.None) " " else it.toString() }
            .chunked(3)
            .forEach { println(it.joinToString("|")) }
        println()
    }

    private fun printWinner(winner: Player) {
        // Don't print the winner if the game have not started yet
        if (!board.all { it == board[0] }) {
            if (winner == Player.None) {
                println("THE GAME ENDS WITH A DRAW!")
            } else {
                println("PLAYER $winner WON! ")
            }
        }
    }
}
