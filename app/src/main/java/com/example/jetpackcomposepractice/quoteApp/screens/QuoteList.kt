package com.example.jetpackcomposepractice.quoteApp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jetpackcomposepractice.quoteApp.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick:(quote: Quote)-> Unit) {
    LazyColumn (content = {
        items(data){
            QuoteListItem(quote = it, onClick  )
        }
    })
}