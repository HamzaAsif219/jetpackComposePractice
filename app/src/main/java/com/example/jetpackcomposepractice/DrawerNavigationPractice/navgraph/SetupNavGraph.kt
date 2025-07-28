package com.example.jetpackcomposepractice.DrawerNavigationPractice.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposepractice.DrawerNavigationPractice.routes.ScreensRoute
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.HomeScreen
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.NotificationsScreen
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.ProfileScreen
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.SettingsScreen


@Composable
fun SetupNavGraph (
    navController: NavHostController,
    innerPadding : PaddingValues
){
    NavHost(navController, startDestination = ScreensRoute.home){
        composable(ScreensRoute.home){
            HomeScreen(innerPadding)
        }
        composable(ScreensRoute.notification){
            NotificationsScreen(innerPadding)
        }
        composable(ScreensRoute.profile){
            ProfileScreen(innerPadding)
        }
        composable(ScreensRoute.settings){
            SettingsScreen(innerPadding)
        }
    }
}