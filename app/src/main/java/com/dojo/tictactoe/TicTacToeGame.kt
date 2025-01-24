package com.dojo.tictactoe

class TicTacToeGame {
    private var currentPlayer = Player.X
    private var board = Array(9) { Player.None }

    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun play(position: Cell) {
        board[position.ordinal] = currentPlayer
        switchPlayers()
    }

    fun getWinner(): Player {
        return if (board[0] == board[3] && board[3] == board[6]) {
            board[0]
        } else {
            Player.None
        }
    }

    private fun switchPlayers() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }

}
