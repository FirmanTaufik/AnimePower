package com.app.animepower

sealed class RouteScreen(var title :String, var route :String, var iconDrawable :Int){
    object SplashScreen:RouteScreen("SplashScreen", "Splashscreen", 0)
    object OnBoardingScreen:RouteScreen("OnBoardingScreen", "OnBoardingScreen", 0)
    object DetailScreen:RouteScreen("DetailScreen", "DetailScreen", 0)

    object SearchScreen:RouteScreen("SearchScreen", "SearchScreen", 0)

    object HomeScreen:RouteScreen("HomeScreen", "HomeScreen", 0)
    object ExploreScreen:RouteScreen("ExploreScreen", "exploreScreen", 0)
    object DownloadScreen:RouteScreen("DownloadScreen", "downloadScreen", 0)
    object ProfileScreen:RouteScreen("ProfileScreen", "profileScreen", 0)

}