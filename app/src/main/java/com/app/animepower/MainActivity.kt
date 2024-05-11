package com.app.animepower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.animepower.model.ItemBottomNavigationModel
import com.app.animepower.screen.DownloadScreen
import com.app.animepower.screen.ExploreScreen
import com.app.animepower.screen.HomeScreen
import com.app.animepower.screen.OnBoardingScreen
import com.app.animepower.screen.ProfileScreen
import com.app.animepower.screen.SplashScreen
import com.app.animepower.ui.theme.AnimePowerTheme
import com.app.animepower.ui.theme.BackgroundBlue
import com.app.animepower.ui.theme.SelectedNavColor
import com.app.animepower.ui.theme.UnSelectedNavColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AnimePowerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = {
                        BottomNavigation{
                            when(it) {
                                0 -> navController.navigate(RouteScreen.HomeScreen.route)
                                1 -> navController.navigate(RouteScreen.ExploreScreen.route)
                                2 -> navController.navigate(RouteScreen.DownloadScreen.route)
                                3 -> navController.navigate(RouteScreen.ProfileScreen.route)
                            }
                        }
                    }) {
                        Box (modifier = Modifier.padding(it)
                            .fillMaxSize()
                            .background(BackgroundBlue)){
                            NavHost(
                                navController = navController, startDestination =
                                RouteScreen.HomeScreen.route
                            ) {
                                composable(RouteScreen.SplashScreen.route) {
                                    SplashScreen(navController)
                                }
                                composable(RouteScreen.OnBoardingScreen.route){
                                    OnBoardingScreen(navController)
                                }
                                composable(RouteScreen.HomeScreen.route){
                                    HomeScreen()
                                }
                                composable(RouteScreen.ExploreScreen.route){
                                    ExploreScreen()
                                }
                                composable(RouteScreen.DownloadScreen.route){
                                    DownloadScreen()
                                }
                                composable(RouteScreen.ProfileScreen.route){
                                    ProfileScreen()
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun BottomNavigation(onClickItemNavigation : (Int) -> Unit) {

    var indexSelected by remember { mutableStateOf(0) }

    val itemsNavigation = arrayListOf(
        ItemBottomNavigationModel(R.drawable.ic_home_normal,
            R.drawable.ic_home_selected,
            true),
        ItemBottomNavigationModel(R.drawable.ic_discovery_normal,
            R.drawable.ic_explore_selected),
        ItemBottomNavigationModel(R.drawable.ic_downlaod_normal,
            R.drawable.ic_download_selected),
        ItemBottomNavigationModel(R.drawable.ic_profile_normal,
            R.drawable.ic_profile_selected),
    )

    Row (modifier = Modifier
        .fillMaxWidth()
        .background(color = BackgroundBlue),
        verticalAlignment = Alignment.CenterVertically){

        itemsNavigation.forEachIndexed { index, item ->
            Column(modifier = Modifier.weight(1f)
                .clickable {
                    indexSelected = index
                    onClickItemNavigation(indexSelected)
                },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = R.drawable.ic_header_bottom_navigation_selected),
                    contentDescription =null,
                    tint = if (indexSelected== index) SelectedNavColor else Color.Transparent)
                Spacer(modifier = Modifier.height(8.dp))
                Icon(painter = painterResource(id = if (indexSelected== index) item.selectedIcon else item.normalIcon),
                    contentDescription =null,
                    tint =  if (indexSelected== index) SelectedNavColor else UnSelectedNavColor,
                    modifier = Modifier.size(25.dp))
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BottomNavigation{

    }
}