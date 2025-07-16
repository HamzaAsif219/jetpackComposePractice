package com.example.jetpackcomposepractice.navigationPractice.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposepractice.navigationPractice.router.Routes


@Composable
fun ScreenC(navController: NavController, allData: String?) {
    BackHandler {
        navController.navigate(Routes.screenA){
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }

    }
    Column(
        Modifier.fillMaxSize().background(
            Brush.linearGradient(
            colors = listOf(
//                Color(0xFFffffff),
                Color(0xFFE3E3E3),
                Color.Cyan
            )
        )),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = " Welcome to screen C", fontSize = 25.sp)
        Text(text = "$allData")
        Button(onClick = {
            navController.navigate(Routes.screenD)
        }) { Text("Go to Screen D") }
    }

}