package com.example.jetpackcomposepractice.DrawerNavigationPractice

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposepractice.DrawerNavigationPractice.navgraph.SetupNavGraph
import com.example.jetpackcomposepractice.DrawerNavigationPractice.navigationItem.NavigationItem
import com.example.jetpackcomposepractice.DrawerNavigationPractice.routes.ScreensRoute
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.DrawerBody
import com.example.jetpackcomposepractice.DrawerNavigationPractice.screens.DrawerHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDrawerNavigationScreen() {
    val drawerNavigationItems = listOf(
        NavigationItem("Home", ScreensRoute.home, Icons.Filled.Home, Icons.Outlined.Home),
        NavigationItem("Profile", ScreensRoute.profile, Icons.Filled.Person, Icons.Outlined.Person),
        NavigationItem(
            "Notification",
            ScreensRoute.notification,
            Icons.Filled.Notifications,
            Icons.Outlined.Notifications,
            8
        ),
        NavigationItem(
            "Settings",
            ScreensRoute.settings,
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        ),
        NavigationItem("Share", "share", Icons.Filled.Share, Icons.Outlined.Share)
    )
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarTitle =
        if (currentRoute != null) {
            drawerNavigationItems[drawerNavigationItems.indexOfFirst {
                it.route == currentRoute
            }].title
        } else {
            drawerNavigationItems[0].title
        }

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet(modifier = Modifier.width(220.dp), drawerContainerColor = Color.Black, drawerShape = RectangleShape) {
            DrawerHeader()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(color = Color.White)
                    .padding(8.dp)
            )
            DrawerBody(
                items = drawerNavigationItems,
                currentRoute = currentRoute.toString(),
                onClick = {
                    if (it.route == ScreensRoute.share) {
                        Toast.makeText(context, "profile shared successfully", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        navController.navigate(it.route) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
//            {currentNavigationItem->
//                navController.navigate(currentNavigationItem.route)
//            }
        }

    }, drawerState = drawerState) {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = topBarTitle) },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
                        }

                    }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
                    }
                }
            )
        }) { innerPadding ->
            SetupNavGraph(navController = navController, innerPadding = innerPadding)
        }
    }
}
