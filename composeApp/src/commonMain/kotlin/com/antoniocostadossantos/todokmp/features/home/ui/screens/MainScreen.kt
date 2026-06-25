package com.antoniocostadossantos.todokmp.features.home.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.antoniocostadossantos.todokmp.features.home.ui.components.NewItemBottonSheet
import com.antoniocostadossantos.todokmp.features.home.ui.components.TodoItem
import com.antoniocostadossantos.todokmp.features.home.ui.viewmodel.HomeIntent
import com.antoniocostadossantos.todokmp.features.home.ui.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.homeViewState.collectAsStateWithLifecycle()
    val sheetState = rememberModalBottomSheetState()
    MaterialTheme {

        if (uiState.showBottomSheet) {
            NewItemBottonSheet(
                state = sheetState,
                value = uiState.value,
                onValueChange = {
                    viewModel.handleIntent(HomeIntent.OnValueChange(it))
                },
                onDismissRequest = {
                    viewModel.handleIntent(HomeIntent.HideBottomSheet)
                },
                onSave = {
                    viewModel.handleIntent(HomeIntent.OnSaveValue)
                }
            )
        }

        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        viewModel.handleIntent(HomeIntent.ShowBottomSheet)
                    }
                ) {
                    Text(text = "Abrir")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).background(Color.White)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = uiState.todos,
                        key = { it.id }
                    ) { todo ->
                        TodoItem(
                            todo.title
                        )
                    }
                }
            }
        }
    }
}