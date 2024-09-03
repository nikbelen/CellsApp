package com.example.cellsapp.presentation.screens.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {
    private val _HomeUIState = MutableStateFlow(HomeUIState())

    val homeState: StateFlow<HomeUIState> = _HomeUIState.asStateFlow()

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
        _HomeUIState.update { homeState: HomeUIState ->
            homeState.copy()
        }
    }
}