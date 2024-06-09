package com.app.animepower.di

import android.util.Log
import com.app.animepower.services.JsoupInterface
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup

@OptIn(DelicateCoroutinesApi::class)
class JsoupImpl() : JsoupInterface {

    override suspend fun getData(url:String): String =
        withContext(Dispatchers.IO) {
            var result = ""
            try {
                val doc = Jsoup.connect(url).timeout(6000)
                    .get().body()
                result = doc.toString()
            } catch (e: Exception) {
                Log.d("TAG", "getData:${e.message} ")
                return@withContext result
            } catch (r: RuntimeException) {
                Log.d("TAG", "getData: ${r.message} ")
                return@withContext result
            }
            return@withContext result
        }


}