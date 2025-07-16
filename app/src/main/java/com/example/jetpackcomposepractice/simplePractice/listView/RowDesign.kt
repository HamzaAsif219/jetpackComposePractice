package com.example.jetpackcomposepractice.simplePractice.listView

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice.R

@Preview(heightDp = 500)
@Composable
fun ListView(){
//    RowDesign(R.drawable.ic_launcher_background, "Programmer", "learn Different Programming")
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        GetCategoryList().map { item->
//            RowDesign(item.image, item.title, item.description)
//        }
//    }
    val context: Context = LocalContext.current
    LazyColumn {
        items(getCategoryList()){ item ->
            RowDesign(item.image, item.title, item.description, onClick = {
                Toast.makeText(context,"clicked on ${item.title}", Toast.LENGTH_LONG).show()
            })
        }
    }
}

@Composable
fun RowDesign(imgId:Int , name:String,description:String, onClick: () -> Unit ){
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ){

        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(imgId),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Red),
                modifier = Modifier.size(48.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
            )
            ItemDescription(name, description, Modifier)
        }
    }
}

@Composable
private fun ItemDescription(name: String, description: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(
            description,
            fontWeight = FontWeight.Thin
        )
    }
}

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_launcher_background, "programming", "learning programming"))
    list.add(Category(R.drawable.ic_launcher_background, "Kotlin", "learning kotlin"))
    list.add(Category(R.drawable.ic_launcher_background, "Java", "learning java"))
    list.add(Category(R.drawable.ic_launcher_background, "JetPack", "learning jetPack Compose"))
    list.add(Category(R.drawable.ic_launcher_background, "Swift", "learning swift"))
    list.add(Category(R.drawable.ic_launcher_background, "C++", "learning C++"))
    list.add(Category(R.drawable.ic_launcher_background, "programming", "learning programming"))
    list.add(Category(R.drawable.ic_launcher_background, "Kotlin", "learning kotlin"))
    list.add(Category(R.drawable.ic_launcher_background, "Java", "learning java"))
    list.add(Category(R.drawable.ic_launcher_background, "JetPack", "learning jetPack Compose"))
    list.add(Category(R.drawable.ic_launcher_background, "Swift", "learning swift"))
    list.add(Category(R.drawable.ic_launcher_background, "C++", "learning C++"))
    list.add(Category(R.drawable.ic_launcher_background, "programming", "learning programming"))
    list.add(Category(R.drawable.ic_launcher_background, "Kotlin", "learning kotlin"))
    list.add(Category(R.drawable.ic_launcher_background, "Java", "learning java"))
    list.add(Category(R.drawable.ic_launcher_background, "JetPack", "learning jetPack Compose"))
    list.add(Category(R.drawable.ic_launcher_background, "Swift", "learning swift"))
    list.add(Category(R.drawable.ic_launcher_background, "C++", "learning C++"))
    list.add(Category(R.drawable.ic_launcher_background, "programming", "learning programming"))
    list.add(Category(R.drawable.ic_launcher_background, "Kotlin", "learning kotlin"))
    list.add(Category(R.drawable.ic_launcher_background, "Java", "learning java"))
    list.add(Category(R.drawable.ic_launcher_background, "JetPack", "learning jetPack Compose"))
    list.add(Category(R.drawable.ic_launcher_background, "Swift", "learning swift"))
    list.add(Category(R.drawable.ic_launcher_background, "C++", "learning C++"))
    return list
}

data class Category(val image:Int, val title:String, val description:String)
