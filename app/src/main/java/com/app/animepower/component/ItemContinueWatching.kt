package com.app.animepower.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.animepower.R
import com.app.animepower.ui.theme.BackgroundCardColor
import com.app.animepower.ui.theme.SelectedNavColor

@Composable
fun ItemContinueWatching() {
    Box(modifier = Modifier.wrapContentSize()
        .padding(horizontal = 10.dp)) {
        Card(
            modifier = Modifier.width(300.dp),
            colors = CardDefaults.cardColors(
                contentColor = BackgroundCardColor,
                containerColor = BackgroundCardColor,
                disabledContentColor = BackgroundCardColor,
                disabledContainerColor = BackgroundCardColor
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(130.dp)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {

                    AsyncImage(
                        model = "https://m.media-amazon.com/images/M/MV5BMzU3YTc1ZjMtZTAyOC00ZTI1LWE0MzItMTllN2M2YWI4MWZmXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    )

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_play_button),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Venom Venom Venom Venom Venom Venom Venom VenomVenomVenom",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 13.dp)
                            .fillMaxWidth(),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Movie",
                        color = Color.Gray,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(start = 13.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "34.00 / 1.41.00",
                        color = Color.Gray,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(start = 13.dp)
                            .fillMaxWidth()
                    )


                    Slider(
                        value = 50f, onValueChange = { },
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Transparent,
                            disabledActiveTrackColor = SelectedNavColor,
                            inactiveTrackColor = Color.Gray,
                            disabledThumbColor = Color.Transparent
                        ),
                        valueRange = 0f..100f,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .fillMaxWidth(),
                        enabled = false
                    )

                }
            }
        }
    }
}