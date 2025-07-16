package com.example.jetpackcomposepractice.stateManagePractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposepractice.stateManagePractice.StateTextScreen
import com.example.jetpackcomposepractice.stateManagePractice.routes.screenRoutes
import com.example.jetpackcomposepractice.stateManagePractice.screens.showDataScreen
import com.example.jetpackcomposepractice.stateManagePractice.viewmodel.StateTestViewModel


@Composable
fun NavigationStateManage(viewModel: StateTestViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = screenRoutes.stateTextScreen, builder = {
        composable (screenRoutes.stateTextScreen){
            StateTextScreen(viewModel, navController)
        }
        composable(screenRoutes.showDataScreen+"/{name}/{surname}", arguments = listOf(
            navArgument("name"){type= NavType.StringType},
            navArgument("surname"){type= NavType.StringType}
        )) {
            val name = it.arguments?.getString("name")
            val surname = it.arguments?.getString("surname")
            showDataScreen(navController,name?:"no name", surname?:"no surname")

        }
    })
}