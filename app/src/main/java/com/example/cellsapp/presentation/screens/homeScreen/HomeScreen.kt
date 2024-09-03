package com.example.cellsapp.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.cellsapp.R
import com.example.cellsapp.presentation.elements.CellCard
import com.example.cellsapp.presentation.elements.CellCardText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState by viewModel.homeState.collectAsStateWithLifecycle()
    Surface(color = Color.Yellow) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color(0xFF310050)),
                    modifier = Modifier.background(Color(0xFF310050)),
                    title = { Text(text = stringResource(id = R.string.screen_title_home_screen), color = Color.White) }
                )
            }
        ) {
             Column(
                 verticalArrangement = Arrangement.SpaceBetween,
                 horizontalAlignment = Alignment.CenterHorizontally,
                 modifier = Modifier
                     .padding(it)
                     .fillMaxSize()
                     .background(
                         brush = Brush.verticalGradient(
                             colors = listOf(
                                 Color(0xFF310050),
                                 Color(0xFF000000)
                             )
                         )
                     )
            ) {
                 LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp), modifier = Modifier.weight(1f, false), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    uiState.cellList.forEach {
                        cell ->item { CellCard(cell) }
                    }
                 }

                 Button(
                     onClick = { viewModel.send(AddCellEvent()) },
                     colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A3472)),
                     shape = RoundedCornerShape(4.dp),
                     modifier = Modifier.padding(16.dp)
                 ) {
                     Text(text = "Сотворить",
                         Modifier
                             .fillMaxWidth(), textAlign = TextAlign.Center, style = MaterialTheme.typography.titleLarge )
                 }
            }
        }
    }
}