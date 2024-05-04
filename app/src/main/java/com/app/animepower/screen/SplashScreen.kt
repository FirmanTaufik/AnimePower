package com.app.animepower.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.animepower.R
import com.app.animepower.RouteScreen
import com.app.animepower.ui.theme.BackgroundBlue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            navController.navigate(RouteScreen.OnBoardingScreen.route)
        }
    }


    Column(
        modifier = Modifier
            .background(color = BackgroundBlue)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = null,
            modifier = Modifier.size(130.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = "MOVIEN", fontSize = 30.sp, modifier = Modifier.padding(0.dp),
            fontFamily = FontFamily(Font(R.font.monda))
        )
    }
}