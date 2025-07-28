package com.example.jetpackcomposepractice.DrawerNavigationPractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.example.jetpackcomposepractice.DrawerNavigationPractice.navigationItem.NavigationItem

@Composable
fun DrawerBody(
    items: List<NavigationItem>,
    currentRoute: String,
    onClick: (NavigationItem) -> Unit
) {
    items.fastForEachIndexed { index, navigationItem ->

        NavigationDrawerItem(shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            label = {
                Text(text = navigationItem.title)
            },
            selected = currentRoute == navigationItem.route,
            onClick = { onClick(navigationItem) },
            icon = {
                Icon(
                    imageVector = if (currentRoute == navigationItem.route) {
                        navigationItem.selectedIcon
                    } else {
                        navigationItem.unSelectedIcon
                    }, contentDescription = navigationItem.title
                )
            },
            badge = {
                navigationItem.badgeCount?.let {
                    Text(text = it.toString())
                }
            },

            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = Color.Cyan,
                unselectedContainerColor = Color.Black,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.White,
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White
            )
        )
    }

}