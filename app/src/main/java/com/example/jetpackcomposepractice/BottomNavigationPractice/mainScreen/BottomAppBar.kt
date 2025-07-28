package com.example.jetpackcomposepractice.BottomNavigationPractice.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.BottomNavigationPractice.dataclass.NavItems
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.HomeScreen
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.NotificationsScreen
import com.example.jetpackcomposepractice.BottomNavigationPractice.screens.SettingsScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomAppBar (){
    val navItemList = listOf(
        NavItems("Home",Icons.Filled.Home, Icons.Outlined.Home,0, false),
        NavItems("Settings", Icons.Filled.Settings, Icons.Outlined.Settings, 0, true),
        NavItems("Notifications", Icons.Filled.Notifications, Icons.Outlined.Notifications, 10, false)
    )
    var selectedIndex by remember { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold (

        topBar = {
            TopAppBar(
                title = {
                Text("Top Bar")
            },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()

                        }

                    }
                    )
                    {
                    Icon(
                        imageVector =Icons.Filled.Menu, contentDescription = "DrawerMenu" )
                    }
                },
                actions = {
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        modifier = Modifier.padding(8.dp))
                    Icon(imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                        modifier = Modifier.padding(8.dp))
                }
            )
        },

        bottomBar = {

            NavigationBar {
                navItemList.forEachIndexed { index, navItems ->
                    NavigationBarItem(
                        selected = selectedIndex==index,
                        onClick = {
                                selectedIndex = index
                                navItems.hasNews= false
                                navItems.badgeCount =0
                                  },
                        icon = {
                            BadgedBox(badge = {
                                if (navItems.badgeCount>0) {
                                    Badge() {
                                        Text(navItems.badgeCount.toString())
                                    }
                                }else if (navItems.hasNews){
                                    Badge()
                                }
                            })
                            {

                            Icon(imageVector =
                            if (index==selectedIndex) {
                                navItems.selectedIcon
                            }else{
                                navItems.unSelectedIcon
                            }
                                , contentDescription = "Icon")
                            }
                        },
                        label = { Text(navItems.label) }
                    )
                }

            }

        }
    ){
        innerPadding ->
        ContentDrawerScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentDrawerScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when(selectedIndex){
        0-> HomeScreen(modifier)
        1-> SettingsScreen(modifier)
        2-> NotificationsScreen(modifier)
    }
}