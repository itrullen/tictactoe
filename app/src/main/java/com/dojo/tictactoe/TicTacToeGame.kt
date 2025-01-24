package com.dojo.tictactoe

class TicTacToeGame {
    private var currentPlayer = Player.X

    fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun play() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }
}
