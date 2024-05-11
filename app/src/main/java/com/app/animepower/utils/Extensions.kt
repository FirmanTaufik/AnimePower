package com.app.animepower.utils


import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import okhttp3.ResponseBody
import java.time.LocalDate
import java.util.Locale
import kotlin.math.absoluteValue


fun String.toFullImageUrl(): String = Constants.TMDB_IMAGE_URL + this
fun String.toYoutubeThumbUrl(): String = Constants.YOUTUBE_THUMB_URL + this + "/0.jpg"

fun Double.roundTo(decimalPlaces: Int): String = "%.${decimalPlaces}f".format(this)

fun Int.minuteToRelativeTime(): String {
    val hours: Int = this / 60
    val minutes: Int = this % 60
    return String.format(
        locale = Locale.ENGLISH,
        format = "%dh:%02dm",
        hours,
        minutes
    )
}


fun Iterable<LazyPagingItems<*>>.isAnyRefreshing(): Boolean =
    any { it.loadState.refresh is LoadState.Loading }

fun Iterable<LazyPagingItems<*>>.hasItems(): Boolean = any { it.itemCount > 0 }

fun Iterable<LazyPagingItems<*>>.isAnyError(): Pair<Boolean, LoadState.Error?> {
    return if (any { it.loadState.refresh is LoadState.Error }) {
        val errorList: LazyPagingItems<*>? = this.find { it.loadState.refresh is LoadState.Error }
        true to errorList?.loadState?.refresh as LoadState.Error
    } else {
        false to null
    }
}

fun Iterable<LazyPagingItems<*>>.refreshAll() {
    return forEach { it.refresh() }
}

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.carouselTransition(
    page: Int,
    pagerState: PagerState
) = graphicsLayer {
    val pageOffset =
        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

    val transformation = lerp(
        start = 0.8f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(
            0f,
            1f
        )
    )
    alpha = transformation
    scaleY = transformation
}

fun Context.openYoutubeLink(url: String) {
    val intentApp = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("vnd.youtube:$url")
    )
    val intentBrowser = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://www.youtube.com/watch?v=$url")
    )
    try {
        this.startActivity(intentApp)
    } catch (ignore: ActivityNotFoundException) {
        this.startActivity(intentBrowser)
    }
}