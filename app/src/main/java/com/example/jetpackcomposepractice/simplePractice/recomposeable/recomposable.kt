package com.example.jetpackcomposepractice.simplePractice.recomposeable

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun recomposable(){

    val state = remember { mutableStateOf(0.0) }
    Log.d("TAGGED", "Logged during initial composition")
    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("TAGGED", "logged during both composition and recomposition")
        Text(text = state.value.toString())
    }
}