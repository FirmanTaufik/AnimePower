package com.app.animepower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.animepower.screen.HomeScreen
import com.app.animepower.screen.OnBoardingScreen
import com.app.animepower.screen.SplashScreen
import com.app.animepower.ui.theme.AnimePowerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AnimePowerTheme {
                val context = LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController, startDestination =
                        RouteScreen.SplashScreen.route
                    ) {
                        composable(RouteScreen.SplashScreen.route) {
                            SplashScreen(navController)
                        }
                        composable(RouteScreen.OnBoardingScreen.route){
                            OnBoardingScreen(navController)
                        }
                        composable(RouteScreen.HomeScreen.route){
                            initTestImpleScrapper().start(context)
                            HomeScreen()
                        }
                    }
                }
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
    AnimePowerTheme {

    }
}