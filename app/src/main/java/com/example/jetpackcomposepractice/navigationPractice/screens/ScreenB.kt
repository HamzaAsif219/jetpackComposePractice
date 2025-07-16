package com.example.jetpackcomposepractice.navigationPractice.screens

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
import androidx.navigation.NavController
import com.example.jetpackcomposepractice.navigationPractice.router.Routes

@Composable
fun ScreenB(navController: NavController, name: String?, age:Int?, currentAddress: String?) {
    val allData= name + age + currentAddress
    Column(Modifier.fillMaxSize().background(
        Brush.radialGradient(
        colors = listOf(
//                Color(0xFFffffff),
            Color(0xFFE3E3E3),
            Color.Blue
        )
    )),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Welcome to Screen B")
        Text(text = "Name: $name")
        Text(text = "Age: $age")
        Text(text = "Address: $currentAddress")
        Button(onClick = {
            navController.navigate(Routes.screenC+"/$allData")
        }) { Text(text = "Go to Screen C") }
    }
}