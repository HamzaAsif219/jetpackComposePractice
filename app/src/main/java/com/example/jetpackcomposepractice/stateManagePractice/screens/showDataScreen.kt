package com.example.jetpackcomposepractice.stateManagePractice.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposepractice.stateManagePractice.routes.screenRoutes

@Composable
fun showDataScreen(navController: NavController, name:String , surname:String){
    BackHandler {
        navController.navigate(screenRoutes.stateTextScreen){
            popUpTo(navController.graph.id){
                inclusive = true
            }
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {

    Text(text = "Show data Screen", fontSize = 30.sp)
        Text(text = "Name: $name")
        Text(text = "Surname: $surname")
    }

}