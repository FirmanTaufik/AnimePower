package com.app.animepower.screen.search

data class ListAnimeModel(
    val items : ArrayList<List> = arrayListOf()
){
    data class List(

        val title :String,
        val release :String,
        val image :String,
        val link :String
    )
}
