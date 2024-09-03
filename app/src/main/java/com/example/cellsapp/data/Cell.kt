package com.example.cellsapp.data

abstract class CellBase {
    abstract val isAlive: Boolean
    abstract val randomComment: String
}

data class Cell(
    override val isAlive: Boolean,
    override val randomComment: String
) : CellBase()

data class Life(
    override val isAlive: Boolean,
    override val randomComment: String
) : CellBase()