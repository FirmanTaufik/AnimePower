package com.app.animepower.sealed

sealed class State {
    object OnLoading:State()
    data class OnSuccess<T>(val data :T) :State()
    data class OnError(val message :String ?="Something Went Wrong Try Again") :State()
}