package com.example.jetpackcomposepractice.DrawerNavigationPractice.navigationItem

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem (
    val title: String,
    val route:String,
    val selectedIcon :ImageVector,
    val unSelectedIcon : ImageVector,
    val badgeCount : Int? = null
)