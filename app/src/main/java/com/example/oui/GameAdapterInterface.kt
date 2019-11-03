package com.example.oui

interface GameAdapterInterface {
    val games: Array<Game>
    fun open(game: Game)
}