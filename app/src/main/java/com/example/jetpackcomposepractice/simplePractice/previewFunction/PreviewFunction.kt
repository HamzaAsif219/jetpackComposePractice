package com.example.jetpackcomposepractice.simplePractice.previewFunction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice.R

@Preview(showBackground = true)
@Composable
fun PreviewFunction(){
    Column {
        Box(
            Modifier
                .padding(
                    start = 8.dp,
                    top = 8.dp,
                    bottom = 8.dp,
                    end = 8.dp
                )
                .background(Color.Gray)
                .fillMaxWidth()
                .height(height = 50.dp),
            contentAlignment = Alignment.Center,


            ) {
            TextShow("developer", 20.sp)
        }
//        Spacer(Modifier.height(10.dp))
        Box((Modifier
            .padding(start = 15.dp, end = 10.dp)
            .background(Color.Red)
            .fillMaxWidth()
            .height(20.dp))){
            TextShow("people")
        }
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "dummy image",
            Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
//                .size(width = 200.dp, height = 100.dp)
                .fillMaxWidth()
                .background(Color.Green),
            colorFilter = ColorFilter.tint(Color.Blue),
            contentScale = ContentScale.FillHeight
        )
        Button(onClick = { }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.LightGray,
            containerColor = Color.Black
        ),
            enabled = true
        ) {
            Text("click more")
            Image(painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "dummy",
                Modifier
                    .padding(start = 10.dp)
                    .size(20.dp),
                colorFilter = ColorFilter.tint(Color.Red))
        }
//        TextField(value = "Hello enter something",
//            onValueChange = {},
//            label = { Text(text = "Enter Message") },
//            placeholder = {})

        TextInput()
        ListOfItems()
    }


}

@Composable
fun TextInput(){
    val state = remember { mutableStateOf("") }

    TextField(value = state.value,
        onValueChange = {
            state.value=it
        },
//        label = {  },
        placeholder = { Text(text = "Enter here...") },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
    )
}

@Composable
fun ListOfItems(){
    Card {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = ""
            )
            Column {
                Text(text = "Programming")
                Text(text = "Learn different languages")
            }
        }
    }
}
@Composable
fun TextShow(name : String, fontSize: TextUnit = 16.sp){
    Text(text = "hello $name",
        fontSize = fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        color = Color.White)
}