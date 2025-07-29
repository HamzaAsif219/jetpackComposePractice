package com.example.jetpackcomposepractice

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomposepractice.BottomNavigationPractice.mainScreen.BottomAppBar
import com.example.jetpackcomposepractice.BottomNavigationPractice.mainScreen.MainBottomBarScreen
import com.example.jetpackcomposepractice.DrawerNavigationPractice.MainDrawerNavigationScreen
import com.example.jetpackcomposepractice.createpdf.TextToPdfScreen
import com.example.jetpackcomposepractice.createpdfFromImage.PdfFromImageScreen
import com.example.jetpackcomposepractice.quoteApp.dataManager.DataManager
import com.example.jetpackcomposepractice.stateManagePractice.viewmodel.StateTestViewModel
import com.example.jetpackcomposepractice.todoApp.viewModel.TodoViewModel
import com.example.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
//            delay(10000)
        DataManager.loadAssetsFromFile(applicationContext)
        }
        val viewModel =ViewModelProvider(this)[StateTestViewModel::class.java]
        val todoViewModel = ViewModelProvider(this)[TodoViewModel::class.java]




        setContent {
            JetPackComposePracticeTheme {
                Surface {
//            PreviewFunction()
//            ListView()
//            recomposable()
//            NotificationScreen()
//            MyAppNavigation()
//            NavigationStateManage(viewModel)
//            TodoListPage(todoViewModel)

//            App()


//                    MainBottomBarScreen()
//                    BottomAppBar()
//                    MainDrawerNavigationScreen()
//                    TextToPdfScreen()
                    PdfFromImageScreen()
                }
            }
        }
    }
}










