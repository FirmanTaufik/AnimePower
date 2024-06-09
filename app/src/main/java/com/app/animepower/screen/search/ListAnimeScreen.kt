package com.app.animepower.screen.search

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.app.animepower.component.ItemListAnime
import com.app.animepower.sealed.State
import com.app.animepower.ui.theme.SelectedNavColor

@Composable
fun ListAnimeScreen(navController: NavHostController, searchViewModel: SearchViewModel) {
    val context = LocalContext.current
    val scrollState = rememberLazyGridState()
    val state = searchViewModel.uiState.collectAsStateWithLifecycle()
    when(state.value){
        is State.OnError ->  {
        val message =( state.value as State.OnError).message
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = {
                 searchViewModel.getSearch()
            }, colors = ButtonDefaults.buttonColors(containerColor = SelectedNavColor)) {
                Text(text = "Try Again", color = Color.White)
            }
            LaunchedEffect(key1 = true) {
                Toast.makeText(context,message, Toast.LENGTH_SHORT ).show()
            }
        }
    }
        State.OnLoading -> {
            Box (modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                CircularProgressIndicator(color = Color.White)
            }
        }
        is State.OnSuccess<*> ->{
            val data = (state.value as State.OnSuccess<*>).data as ListAnimeModel
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                state = scrollState,
                contentPadding = PaddingValues(5.dp)
            )  {
                itemsIndexed(data.items) { index, item ->
                    ItemListAnime(item = item ) {

                    }
                }

            }
        }
    }


}
