package com.example.jetpackcomposepractice.DrawerNavigationPractice.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DrawerHeader (){
    Column (modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Icon(imageVector = Icons.Filled.Badge, contentDescription = "HeaderIcon", tint = Color.Cyan,
            modifier = Modifier.size(100.dp)
                .padding(top = 10.dp))
        Text("JetPack Compose", fontSize = 20.sp, color = Color.White,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
    }
}