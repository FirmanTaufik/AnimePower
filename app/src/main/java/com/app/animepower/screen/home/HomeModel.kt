package com.app.animepower.screen.home

data class HomeModel(
    val recentUpdateList: ArrayList<RecentUpdate> = arrayListOf(),
    val popularUpdateList: ArrayList<PopularUpdate> = arrayListOf()
) {
    data class PopularUpdate(
        val title :String,
        val episode :String,
        val genre :String,
        val image :String,
        val link :String
    )
    data class RecentUpdate(
        val title :String,
        val episode :String,
        val image :String,
        val link :String
    )
}
