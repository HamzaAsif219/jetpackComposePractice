package com.example.jetpackcomposepractice.quoteApp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.quoteApp.models.Quote


@Composable
fun QuoteListItem (quote: Quote, onClick: (quote: Quote)-> Unit){
    Card (elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)
            .background(Color.White)

    ){
        Row (modifier = Modifier
            .background(Color.White)
        ){
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(60.dp)
                    .padding(12.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = quote.quote?:"",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.height(30.dp))
                Box(modifier = Modifier.background(Color(0xFFD3D3D3))
                    .fillMaxWidth(.4f)
                    .height(1.dp)
                )
                Text(text = quote.author?:"",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin
                    )
            }
        }
    }
}

