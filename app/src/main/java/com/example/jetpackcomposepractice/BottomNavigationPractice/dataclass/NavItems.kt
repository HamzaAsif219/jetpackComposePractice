package com.example.jetpackcomposepractice.BottomNavigationPractice.dataclass

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems (
    val label : String,
    val selectedIcon : ImageVector,
    val unSelectedIcon : ImageVector,
    var badgeCount :Int,
    var hasNews :Boolean
)