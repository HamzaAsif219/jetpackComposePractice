package com.example.jetpackcomposepractice.quoteApp.dataManager

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcomposepractice.quoteApp.models.Quote
import com.example.jetpackcomposepractice.quoteApp.enums.Pages
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var currentQuote : Quote? = null
    var currentPage= mutableStateOf(Pages.LISTING)
    val isDataLoaded= mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }
    fun switchPage(quote: Quote?){
        if (currentPage.value== Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}