package com.example.jetpackcomposepractice.quoteApp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcomposepractice.quoteApp.dataManager.DataManager
import com.example.jetpackcomposepractice.quoteApp.enums.Pages
import com.example.jetpackcomposepractice.quoteApp.screens.QuoteDetail
import com.example.jetpackcomposepractice.quoteApp.screens.QuoteListScreen

@Composable
fun App(){
    if (DataManager.isDataLoaded.value){

        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPage(it)

            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
    else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f),

            ){
            Text(text = "Loading...",
                style = MaterialTheme.typography.bodyMedium)
        }
    }

}