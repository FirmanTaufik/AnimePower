package com.app.animepower.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.animepower.ui.theme.BackgroundBlue

@Composable
fun HomeScreen() {
    Box (modifier = Modifier.background(BackgroundBlue)){
        Text(text = "Ini Home Screen")
    }

}