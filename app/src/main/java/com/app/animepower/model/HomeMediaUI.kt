package com.app.animepower.model


import androidx.annotation.Keep

@Keep
data class HomeMediaUI(
    val id: Int,
    val name: String,
    val posterPath: String,
    val backdropPath: String,
    val overview: String
)