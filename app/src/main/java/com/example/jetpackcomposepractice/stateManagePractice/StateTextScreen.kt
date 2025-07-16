package com.example.jetpackcomposepractice.stateManagePractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposepractice.stateManagePractice.routes.screenRoutes
import com.example.jetpackcomposepractice.stateManagePractice.viewmodel.StateTestViewModel

@Composable
fun StateTextScreen(viewModel: StateTestViewModel, navController: NavController) {
//    var name by rememberSaveable {
//        mutableStateOf("")
//    }

    val name by viewModel.name.observeAsState(initial = "")
    val surname by viewModel.surname.observeAsState(initial = "")

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .background(Brush.linearGradient(
                colors = listOf(
                    Color.Gray,
                    Color.White,
                    Color.Blue
                )
            ))
    ) {
        MyText()
        MyTextField(name, "Enter name", onNameChange = {
//            name=it
            viewModel.onNameUpdate(it)
        })
        MyTextField(surname, "Enter Surname", onNameChange = {
//            name=it
            viewModel.onSurnameUpdate(it)
        })

        Button(onClick = {
            navController.navigate(screenRoutes.showDataScreen+ "/$name /$surname")
        }) { Text(text = "Show Data") }
    }

}

//@Composable
//fun MyText(name: String){
//    Text(text = " hello $name" , fontSize = 30.sp)
//}
@Composable
fun MyText(){
    Text(text = "Hello, Please enter" , fontSize = 30.sp)
}

@Composable
fun MyTextField(name:String, placeHolder:String , onNameChange:(String)->Unit){

    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text(text = placeHolder) },
        singleLine = true
    )
}


