package com.example.jetpackcomposepractice.BottomNavigationPractice.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice.BottomNavigationPractice.dataclass.NavItems
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.HomeScreen
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.NotificationsScreen
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.ProfileScreen
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.SettingsScreen
import com.example.jetpackcomposepractice.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBottomBarScreen() {
    val navItemsList = listOf(
        NavItems("Home", Icons.Filled.Home, Icons.Outlined.Home, 0, false),
        NavItems("Notifications", Icons.Filled.Notifications, Icons.Outlined.Notifications,5, false),
        NavItems("Settings", Icons.Filled.Settings,Icons.Outlined.Settings,0, true),
        NavItems("Profile", Icons.Filled.Person, Icons.Outlined.Person,12, true),
    )
    var selectedIndex by remember { mutableStateOf(0) }


    Scaffold (modifier = Modifier.fillMaxSize(),

        bottomBar = {

            NavigationBar {

                navItemsList.forEachIndexed { index, navItems ->
                    NavigationBarItem(
                        selected = selectedIndex==index
                        ,
                        onClick = {
                            selectedIndex =index
                            navItems.badgeCount=0
                            navItems.hasNews= false
                                  },
                        icon = {
                            BadgedBox(badge = {
                                if (navItems.badgeCount > 0) {
                                    Badge() {
                                        Text(navItems.badgeCount.toString())
                                    }
                                }else if ( navItems.hasNews){
                                        Badge()
                                    }

                            }) {

                            Icon(imageVector =
                            if (index==selectedIndex) {
                                navItems.selectedIcon
                            }else{
                                navItems.unSelectedIcon
                            }
                            , contentDescription = "Icon")
                            }
                        },
                        label = {
                            Text(navItems.label, fontSize = (10.sp))
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = Color(0xFFC94E4E),
                            selectedTextColor = Color(0xFFC94E4E),
                            unselectedIconColor = Color.Black,
                            unselectedTextColor = Color.Black,
                            selectedIndicatorColor = Color(0xFFF89F9F),
                            disabledIconColor = Color.Gray,
                            disabledTextColor = Color.Gray
                        ),
                    )
                }
            }
        }
    )
    { innerPadding->

        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex :Int) {
    when(selectedIndex){
        0-> HomeScreen(modifier)
        1-> NotificationsScreen(modifier)
        2-> SettingsScreen(modifier)
        3-> ProfileScreen(modifier)
    }


}
