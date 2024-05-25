package com.app.animepower.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.animepower.R
import com.app.animepower.component.SearchBar

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier.fillMaxWidth(),  ){

            Text(text = "Search", fontWeight = FontWeight.Bold, fontSize = 23.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textAlign = TextAlign.Center)

            IconButton(onClick = {
                navHostController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left_circle),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        SearchBar(hint = "Search")

        //FEATURE

        Spacer(modifier = Modifier.height(15.dp))

        val list = listOf("Action", "Adventure", "Comedy", "Drama","Horror","Horror Comedy",
            "Fantasy","Thriller")

        Text(text = "Featured", fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp))
        Spacer(modifier = Modifier.height(10.dp))
        FlowRow(
            modifier = Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            maxItemsInEachRow = 3
        ) {
            list.forEach {
                Box (modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))){
                    Text(text = it, color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp,),
                        fontWeight = FontWeight.Bold)
                }
            }
             
        }

        Spacer(modifier = Modifier.height(15.dp))

        val listSearch = listOf("Venom", "Spiderman: No Way Home", "Harry Potter", "Avenger Endgame","Captain Amerika",
            "Despicable Me",  "Hulk","Tom and Jerry")

        Text(text = "Searched", fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp))
        Spacer(modifier = Modifier.height(10.dp))
        FlowRow(
            modifier = Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            maxItemsInEachRow = 3
        ) {
            listSearch.forEach {
                Box (modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))){
                    Text(text = it, color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp,),
                        fontWeight = FontWeight.Bold)
                }
            }

        }

    }
}