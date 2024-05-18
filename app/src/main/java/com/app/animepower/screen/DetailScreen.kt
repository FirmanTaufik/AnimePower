package com.app.animepower.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.animepower.R
import com.app.animepower.component.ItemTrending
import com.app.animepower.ui.theme.BackgroundBlue
import com.app.animepower.ui.theme.UnSelectedNavColor
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun DetailScreen() {
    val state = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = BackgroundBlue)
            .fillMaxWidth()
            .verticalScroll(state)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(320.dp)
        ) {
            AsyncImage(
                model = "https://m.media-amazon.com/images/M/MV5BYWU4MDMxZDEtZmYzMy00ZWRlLTliYmUtZjk1NzliN2M5NjRiXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_FMjpg_UX1000_.jpg",
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_load_placeholder),
                error = painterResource(id = R.drawable.ic_load_error),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color.Transparent, BackgroundBlue)
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_left_circle),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_downlaod_normal),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Spiderman : No Way Home", fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Action, Crime, Drama | 2018 | 18+", fontSize = 15.sp,
                        color = Color.Gray
                    )

                    var rating: Float by remember { mutableStateOf(3.2f) }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RatingBar(
                            value = rating,
                            style = RatingBarStyle.Fill(
                                activeColor = Color.Yellow,
                                inActiveColor = UnSelectedNavColor
                            ),
                            onValueChange = {
                                rating = it
                            },
                            onRatingChanged = {

                            },
                            size = 20.dp,
                            spaceBetween = 2.dp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "6.7",
                            color = Color.White,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play_button),
                        contentDescription = null
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Episodes", fontWeight = FontWeight.Bold, fontSize = 18.sp,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(8) {
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .wrapContentHeight()
                        .padding(start = if (it == 0) 15.dp else 10.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        shape = RoundedCornerShape(15.dp)
                    ) {

                        Box(modifier = Modifier.fillMaxSize()) {

                            AsyncImage(
                                model = "https://m.media-amazon.com/images/M/MV5BYWU4MDMxZDEtZmYzMy00ZWRlLTliYmUtZjk1NzliN2M5NjRiXkEyXkFqcGdeQXVyMTA0MTM5NjI2._V1_FMjpg_UX1000_.jpg",
                                contentDescription = null,
                                placeholder = painterResource(id = R.drawable.ic_load_placeholder),
                                error = painterResource(id = R.drawable.ic_load_error),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                            Column(
                                modifier = Modifier
                                    .background(
                                        brush = Brush.verticalGradient(
                                            listOf(Color.Transparent, Color.Black)
                                        )  )
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.BottomStart)
                            ) {
                                Text(
                                    text = "Episode - 1",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(text = "The End of the Road")
                            }
                        }
                    }
                }
            }
        }
    }
}