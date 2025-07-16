package com.example.jetpackcomposepractice.navigationPractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposepractice.navigationPractice.router.Routes
import kotlinx.coroutines.delay

@Composable
fun ScreenA(navController: NavController) {
    val setName= "John"
    val setAge = 13
    val address = "Punjab, Pakistan"
    Column( Modifier.fillMaxSize().background(
        Brush.sweepGradient(
        colors = listOf(
//                Color(0xFFffffff),
            Color(0xFFE3E3E3),
            Color.Green
        )
    )),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Screen A", fontSize = 35.sp)
        LaunchedEffect(Unit) {
            delay(3000) // 3-second delay
            navController.navigate(Routes.screenB + "/$setName/$setAge/$address")
        }
//        Button(onClick = {
//            navController.navigate(Routes.screenB+"/$setName"+"/$setAge"+"/$address")
//        }) {
//            Text(text = "Go to screen B")
//        }
    }
}