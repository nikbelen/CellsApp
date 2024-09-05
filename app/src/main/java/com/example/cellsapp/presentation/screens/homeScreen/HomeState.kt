package com.example.cellsapp.presentation.screens.homeScreen

import com.example.cellsapp.data.CellBase

data class HomeUIState(
    var cellList: List<CellBase> = listOf()
)