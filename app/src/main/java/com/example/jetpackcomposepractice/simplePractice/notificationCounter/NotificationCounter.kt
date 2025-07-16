package com.example.jetpackcomposepractice.simplePractice.notificationCounter

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.R

@Preview
@Composable
fun NotificationScreen(){
    val count :MutableState<Int> = rememberSaveable{mutableStateOf(0)}
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ){
        NotificationCounter(count.value, { count.value++ } )
        MessageBar(count.value)
    }
}


@Composable
fun MessageBar(count: Int){
    Card(elevation = CardDefaults.elevatedCardElevation(4.dp)) {
        Row (Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.Gray),
            modifier = Modifier.size(30.dp).padding(8.dp))
        Text("Message sent so far - $count", Modifier.padding(8.dp))
    }
}
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
//    var count :MutableState<Int> = rememberSaveable{mutableStateOf(0)}
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent ${count} notifications")
        Button(onClick = {
            increment()
            Log.d("CODESTATE", "button clicked")
        }) {
            Text("Send Notification", fontWeight = FontWeight.SemiBold)
        }
    }
}