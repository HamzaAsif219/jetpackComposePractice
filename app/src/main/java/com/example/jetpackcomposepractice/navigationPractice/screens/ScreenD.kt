package com.example.jetpackcomposepractice.navigationPractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun ScreenD() {
    Column (Modifier.fillMaxSize().background(
        Brush.horizontalGradient(
        colors = listOf(
//                Color(0xFFffffff),
            Color(0xFFE3E3E3),
            Color.Magenta
        )
    )),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text("Welcome to Screen D")
    }
}