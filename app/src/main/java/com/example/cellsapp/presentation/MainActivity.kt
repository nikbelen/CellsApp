package com.example.cellsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.cellsapp.presentation.screens.homeScreen.HomeScreen
import com.example.cellsapp.presentation.theme.CellsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CellsAppTheme {
                Surface(color = Color.Yellow) {
                    Scaffold {
                        HomeScreen(modifier = Modifier.padding(it))
                    }
                }
            }
        }
    }
}