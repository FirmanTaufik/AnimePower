package com.app.animepower.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.animepower.di.JsoupImpl
import com.app.animepower.sealed.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(val jsoup :JsoupImpl) :ViewModel() {
    private var _uiState = MutableStateFlow<State>(State.OnLoading)
    var uiState = _uiState.asStateFlow()


    fun getPopular(listRecent: ArrayList<HomeModel.RecentUpdate>) = viewModelScope.launch {
        val result = jsoup.getData("https://ajax.gogocdn.net/ajax/page-recent-release-ongoing.html?page=1")
        if (result.isNotEmpty()) {
            val listPopular = getListPopulaar(result)
            val model = HomeModel(recentUpdateList = listRecent,
                popularUpdateList = listPopular)
            val response = State.OnSuccess(model)
            _uiState.emit(response)

        } else _uiState.emit(State.OnError())
    }

    fun getHome() = viewModelScope  .launch {
            _uiState.value =State.OnLoading
            val result = jsoup.getData("https://gogoanime3.co/")
            if (result.isNotEmpty()) {
                getPopular(  getListRecent(result) )
            }else _uiState.emit(State.OnError())

        }

    private fun getListPopulaar(result: String): ArrayList<HomeModel.PopularUpdate> {
        var list = arrayListOf<HomeModel.PopularUpdate>()
        val doc = Jsoup.parse(result)
        val populars = doc?.select("div.added_series_body")
            ?.select("ul")?.select("li")
        Log.d("TAG", "getListPopulaar: $populars")
        populars?.forEach {
            //background: url('https://gogocdn.net/cover/sasayaku-you-ni-koi-wo-utau-1711738463.png');
            val image = it.select("div.thumbnail-popular") .attr("style")
                .substringAfter("('").substringBefore("')")

            val link = it.select("a").attr("href")
            val title = it.select("a").attr("title")
            val stringBuilder = StringBuilder()
            val genres = it.select("p.genres").select("a")
            genres.forEach {
                stringBuilder.append(it.text())
            }
            val episode = it.select("p").last()?.text()
            Log.d("TAG", "getListPopulaar: $title  $stringBuilder $episode $image $link")
            list.add(HomeModel.PopularUpdate(title, episode ?: "-", stringBuilder.toString(), image, link))
        }
        return list
    }

    private fun getListRecent(result: String): ArrayList<HomeModel.RecentUpdate> {
        var list = arrayListOf<HomeModel.RecentUpdate>()
        val doc = Jsoup.parse(result)
        val element = doc.getElementById("load_recent_release")
        val listElemt = element.select("div.last_episodes")
            .select("ul").select("li")
        listElemt.forEach {
            val image = it.select("a").select("img").attr("src")
            val link = it.select("a").attr("href")
            val title = it.select("p.name").text()
            val episode = it.select("p.episode").text()
            Log.d("TAG", "getListRecent: $title $episode $image $link")
            list.add(HomeModel.RecentUpdate(title, episode, image, link))
        }
        return list
    }
}