package com.antoniocostadossantos.todokmp.features.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NewItemBottonSheet(
    modifier: Modifier = Modifier,
    state: SheetState,
    value: String,
    onValueChange: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onSave: () -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier
            .padding(horizontal = 8.dp),
        sheetState = state,
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = value,
                onValueChange = onValueChange
            )
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = onSave,
            ) {
                Text(
                    text = "Salvar"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun NewItemBottonSheetPreview() {
    NewItemBottonSheet(
        value = "Teste",
        onValueChange = {},
        onDismissRequest = { },
        onSave = { },
        state = rememberModalBottomSheetState()
    )
}