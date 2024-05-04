package com.app.animepower

sealed class RouteScreen(var title :String, var route :String, var iconDrawable :Int){
    object SplashScreen:RouteScreen("SplashScreen", "Splashscreen", 0)
    object OnBoardingScreen:RouteScreen("OnBoardingScreen", "OnBoardingScreen", 0)
    object HomeScreen:RouteScreen("HomeScreen", "HomeScreen", 0)
}