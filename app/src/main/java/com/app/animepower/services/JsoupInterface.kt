package com.app.animepower.services

interface JsoupInterface {

   suspend fun getData(url :String) :String

}