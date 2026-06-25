package com.antoniocostadossantos.todokmp.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoItem(
    title: String
) {

    Surface(
        color = Color.White,
        border = BorderStroke(1.dp, Color.Blue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
    }

}

@Preview
@Composable
fun TodoItemPreview() {
    TodoItem(
        title = "teste"
    )
}