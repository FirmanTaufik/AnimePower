package com.app.animepower.component

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.app.animepower.R
import com.app.animepower.model.HomeMediaUI
import com.app.animepower.screen.home.HomeModel
import com.app.animepower.ui.theme.SelectedNavColor
import com.app.animepower.ui.theme.UnSelectedNavColor
import com.app.animepower.ui.theme.flix_color_translucent_black
import com.app.animepower.utils.Constants
import com.app.animepower.utils.carouselTransition
import com.app.animepower.utils.toFullImageUrl
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class
)
@Composable
fun MediaCarousel(
    list: ArrayList<HomeModel.PopularUpdate>,
    totalItemsToShow: Int = 10,
    carouselLabel: String = "",
    autoScrollDuration: Long = Constants.CAROUSEL_AUTO_SCROLL_TIMER,
    onItemClicked: (HomeModel.PopularUpdate) -> Unit
) {

    var currentPage by remember { mutableStateOf(0) }
    val pageCount = list.size.coerceAtMost(totalItemsToShow)
    val pagerState: PagerState = rememberPagerState(pageCount = { pageCount })
    LaunchedEffect(pagerState) {
        snapshotFlow {
            pagerState.currentPage
        }.distinctUntilChanged().collect { page ->
            currentPage = page
        }
    }

    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    if (isDragged.not()) {
        with(pagerState) {
            if (pageCount > 0) {
                var currentPageKey by remember { mutableIntStateOf(0) }
                LaunchedEffect(key1 = currentPageKey) {
                    launch {
                        delay(timeMillis = autoScrollDuration)
                        val nextPage = (currentPage + 1).mod(pageCount)
                        animateScrollToPage(
                            page = nextPage,
                            animationSpec = tween(
                                durationMillis = Constants.ANIM_TIME_LONG
                            )
                        )
                        currentPageKey = nextPage
                    }
                }
            }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Box {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(
                    horizontal = dimensionResource(id = R.dimen.double_padding)
                ),
                pageSpacing = dimensionResource(id = R.dimen.normal_padding)
            ) { page: Int ->
                val item  = list[page]
                item?.let {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        onClick = { onItemClicked(it) },
                        modifier = Modifier.carouselTransition(
                            page,
                            pagerState
                        )
                    ) {
                        CarouselBox(it)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            items(pageCount){
                Box (modifier = Modifier
                    .wrapContentSize()
                    .padding(horizontal = 5.dp)){
                    Box (modifier = Modifier
                        .size(10.dp)
                        .background(
                            color = if (currentPage == it) SelectedNavColor else Color.White,
                            shape = RoundedCornerShape(50)
                        )){

                    }
                }
            }
        }

        Log.d("FirmanTAG", "MediaCarousel: $currentPage")

        /* if (carouselLabel.isNotBlank()) {
             Text(
                 text = carouselLabel,
                 style = MaterialTheme.typography.labelSmall
             )
         }*/
    }
}

@Composable
fun CarouselBox(item: HomeModel.PopularUpdate) {
    Box {
        AsyncImage(
            model = item.image,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_load_placeholder),
            error = painterResource(id = R.drawable.ic_load_error),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(
                    dimensionResource(id = R.dimen.home_grid_poster_height)
                )
                .fillMaxWidth()
        )
        val gradient = remember {
            Brush.verticalGradient(
                listOf(
                    Color.Transparent,
                    flix_color_translucent_black
                )
            )
        }

        Column(
            modifier = Modifier
                /*  .padding(
                    horizontal = dimensionResource(id = R.dimen.normal_padding),
                    vertical = dimensionResource(id = R.dimen.small_padding)
                )*/
                .fillMaxWidth()
                .background(gradient)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = item.title,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = item.genre,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
            )


            Spacer(modifier = Modifier.height(5.dp))
            var rating: Float by remember { mutableStateOf(3.2f) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                /*RatingBar(
                    value = rating,
                    style = RatingBarStyle.Fill(activeColor = Color.Yellow, inActiveColor = UnSelectedNavColor),
                    onValueChange = {
                        rating = it
                    },
                    onRatingChanged = {

                    },
                    size = 13.dp,
                    spaceBetween = 2.dp
                )
                Spacer(modifier = Modifier.width(5.dp))*/
                Text(
                    text = item.episode,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        items(5){
            Box (modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 5.dp)){
                Box (modifier = Modifier
                    .size(10.dp)
                    .background(
                        color = SelectedNavColor,
                        shape = RoundedCornerShape(50)
                    )){

                }
            }
        }
    }
}