package com.example.cellsapp.presentation.screens.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cellsapp.data.Cell
import com.example.cellsapp.data.Life
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import okhttp3.internal.toImmutableList
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    private val _HomeUIState = MutableStateFlow(HomeUIState())

    val homeState: StateFlow<HomeUIState> = _HomeUIState.asStateFlow()

    var lastAliveIndex = -1;

    init {


    }

    fun send(event: HomeEvent) {
        when (event) {
            is AddCellEvent -> {
                addCell()
            }
        }
    }

    private fun addCell() {
        Log.d("AAA", "Cell Added")
        val cells = homeState.value.cellList.toMutableList()
        if (Random.nextInt(0, 10) >= 5)
            cells.add(Cell(true, "Да не умер он"));
        else cells.add(Cell(false, "Все-таки умер"))
        val len = cells.size
        if(len >=3){
            if(cells[len-1] is Cell && cells[len-2] is Cell && cells[len-3] is Cell)
            {
                if (cells[len-1].isAlive && cells[len-2].isAlive && cells[len-3].isAlive){
                    cells.add(Life(true, "Оно живое!"))
                    lastAliveIndex = len
                }
                else if (!cells[len-1].isAlive && !cells[len-2].isAlive && !cells[len-3].isAlive && lastAliveIndex > 0){
                    cells[lastAliveIndex] = Life(false, "Она погибла")
                    lastAliveIndex = -1
                }

            }
        }

        _HomeUIState.update {
                homeState: HomeUIState ->
            homeState.copy(cellList = cells.toImmutableList())
        }
    }
}