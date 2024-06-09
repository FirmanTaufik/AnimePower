package com.app.animepower.screen.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.animepower.di.JsoupImpl
import com.app.animepower.screen.home.HomeModel
import com.app.animepower.sealed.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(val jsoup :JsoupImpl) :ViewModel() {
    private var keyword= mutableStateOf("")
    private var _uiState = MutableStateFlow<State>(State.OnLoading)
    var uiState = _uiState.asStateFlow()

    fun setKeyword(keyword:String){
        this.keyword.value = keyword
    }
    fun getSearch( ) = viewModelScope  .launch {
            _uiState.value =State.OnLoading
          val result = jsoup.getData("https://gogoanime3.co/search.html?keyword=${keyword.value}")
            if (result.isNotEmpty()) {
                val list =  arrayListOf<ListAnimeModel.List>()
                val doc = Jsoup.parse(result)
                val mainBody = doc.select("div.main_body")
                    .select("div.last_episodes")
                val li = mainBody.select("ul.items").select("li")
                li.forEach {
                    val image = it.select("a").select("img").attr("src")
                    val link = it.select("a").attr("href")
                    val title = it.select("p.name").text()
                    val released = it.select("p.released").text()
                    Log.d("TAG", "getListRecent: $title $released $image $link")
                    list.add(ListAnimeModel.List(title, released, image, link))
                }
                _uiState.emit(State.OnSuccess(ListAnimeModel(list)))

            }else _uiState.emit(State.OnError())

        }


}