package com.app.animepower.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ItemTrending(it: Int, onClickItem : ()->Unit) {
    Column(
        modifier = Modifier
            .clickable {
                onClickItem()
            }
            .width(120.dp)
            .wrapContentHeight()
            .padding(start = if (it == 0) 15.dp else 10.dp),
    ) {
        Card(
            modifier = Modifier.
            fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            AsyncImage(
                model = "https://m.media-amazon.com/images/S/pv-target-images/f5faf49c6612aaef51a7112f9dbbacf2ced1963f219c91e789fcfc75f2c4cffe.jpg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                clipToBounds = true
            )
        }
        Text(text = "Spiderman : No Way Home cdcdsvfsdv fjddbjfbsd jdhfjsdhjfhsd jkvhdsihvschvxcihvcxiohvcxoov",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 13.sp,
            lineHeight = 15.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis)
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "2021", fontSize = 10.sp,
                color = Color.Gray)
            Row (modifier = Modifier.wrapContentSize()){
                Icon(imageVector = Icons.Default.Star, contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.size(13.dp))
                Text(text = "9.5", fontSize = 10.sp,
                    color = Color.Gray)
            }
        }

    }
}