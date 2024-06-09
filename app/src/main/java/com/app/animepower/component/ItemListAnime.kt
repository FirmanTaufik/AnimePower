package com.app.animepower.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.animepower.screen.search.ListAnimeModel

@Composable
fun ItemListAnime(item: ListAnimeModel.List,  onClickItem: ()->Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .clickable {
                onClickItem()
            }
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            AsyncImage(
                model =item.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                clipToBounds = true
            )
        }
        Text(text = item.title,
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 13.sp,
            lineHeight = 15.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis)
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = item.release, fontSize = 10.sp,
                color = Color.Gray)
            /* Row (modifier = Modifier.wrapContentSize()){
                 Icon(imageVector = Icons.Default.Star, contentDescription = null,
                     tint = Color.Yellow,
                     modifier = Modifier.size(13.dp))
                 Text(text = "9.5", fontSize = 10.sp,
                     color = Color.Gray)
             }*/
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}