package com.example.jetpackcomposepractice.navigationPractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposepractice.navigationPractice.router.Routes
import com.example.jetpackcomposepractice.navigationPractice.screens.ScreenA
import com.example.jetpackcomposepractice.navigationPractice.screens.ScreenB
import com.example.jetpackcomposepractice.navigationPractice.screens.ScreenC
import com.example.jetpackcomposepractice.navigationPractice.screens.ScreenD

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.screenA, builder = {
        composable(Routes.screenA) {
            ScreenA(navController)
        }
        composable(
            Routes.screenB+"/{name}/{age}/{address}", arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("age"){type = NavType.IntType},
                navArgument("address"){type= NavType.StringType}
        )) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age")
            val address = it.arguments?.getString("address")

            ScreenB(navController, name, age,address )
        }
        composable(Routes.screenC+"/{all_data}") {
            val allData = it.arguments?.getString("all_data")
            ScreenC(navController, allData)
        }
        composable(Routes.screenD) {
            ScreenD()
        }
    })
}