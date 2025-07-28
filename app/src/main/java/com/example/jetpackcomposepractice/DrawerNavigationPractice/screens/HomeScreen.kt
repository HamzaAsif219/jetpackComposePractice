package com.example.jetpackcomposepractice.DrawerNavigationPractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen (innerPadding: PaddingValues){
    Column (modifier = Modifier.fillMaxSize()
        .background(Color(0xFF2196F3)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Home Screen",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold)
    }
}