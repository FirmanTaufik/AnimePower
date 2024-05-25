package com.app.animepower.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.app.animepower.R
import com.app.animepower.RouteScreen
import com.app.animepower.component.ItemContinueWatching
import com.app.animepower.component.ItemTrending
import com.app.animepower.component.MediaCarousel
import com.app.animepower.model.HomeMediaUI
import com.app.animepower.ui.theme.BackgroundBlue
import com.app.animepower.ui.theme.BackgroundCardColor
import com.app.animepower.ui.theme.SelectedNavColor
import com.app.animepower.ui.theme.UnSelectedNavColor
import com.app.animepower.ui.theme.WhiteColor300

@Composable
fun HomeScreen(navHostController: NavHostController, onClickToDetail: () -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBlue)
    ) {
        //TOP BAR
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.subtract),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "MOVIEN", fontSize = 15.sp, modifier = Modifier.padding(top = 3.dp),
                    fontFamily = FontFamily(Font(R.font.monda)),
                    color = Color.White
                )
            }
            Row(modifier = Modifier.wrapContentWidth()) {
                IconButton(onClick = {
                    navHostController.navigate(RouteScreen.SearchScreen.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        //MENU TOP
        var indexSelected by remember { mutableStateOf(0) }
        var menus = arrayListOf("Movies", "Tv Series", "Theater", "Anime")
        Row(modifier = Modifier.fillMaxWidth()) {
            menus.forEachIndexed { index, s ->
                Text(
                    text = s, modifier = Modifier
                        .weight(1f)
                        .clickable {
                            indexSelected = index
                        },
                    color = if (indexSelected == index) WhiteColor300 else UnSelectedNavColor,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        // Card Slider
        val list = listOf(
            HomeMediaUI(
                0,
                "Venom 3",
                "https://m.media-amazon.com/images/M/MV5BMzU3YTc1ZjMtZTAyOC00ZTI1LWE0MzItMTllN2M2YWI4MWZmXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                "backdrop",
                "overview"
            ),
            HomeMediaUI(
                0,
                "Venom 3",
                "https://m.media-amazon.com/images/M/MV5BMzU3YTc1ZjMtZTAyOC00ZTI1LWE0MzItMTllN2M2YWI4MWZmXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                "backdrop",
                "overview"
            ),
            HomeMediaUI(
                0,
                "Venom 3",
                "https://m.media-amazon.com/images/M/MV5BMzU3YTc1ZjMtZTAyOC00ZTI1LWE0MzItMTllN2M2YWI4MWZmXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                "backdrop",
                "overview"
            ),
        )
        MediaCarousel(
            list = list,
            carouselLabel = "Movie",
            onItemClicked = { }
        )

        //CONTINUE WATCHING
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Continue watching",
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.wrapContentWidth()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = SelectedNavColor
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
        }


        LazyRow(modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(8){
                ItemContinueWatching()
            }
        }



        //TRENDING NOW CONTENT

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Trending Now",
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.wrapContentWidth()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = SelectedNavColor
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
            }
        }

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(8) {
                ItemTrending(it) {
                    onClickToDetail()
                }
            }
        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun S() {
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
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    model = "https://m.media-amazon.com/images/M/MV5BMzU3YTc1ZjMtZTAyOC00ZTI1LWE0MzItMTllN2M2YWI4MWZmXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                    contentDescription = null
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play_button),
                        contentDescription = null
                    )
                }
            }
        }
    }
}