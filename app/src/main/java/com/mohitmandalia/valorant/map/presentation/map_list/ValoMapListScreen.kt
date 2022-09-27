package com.mohitmandalia.valorant.map.presentation.map_list


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mohitmandalia.valorant.core.util.Screen
import com.mohitmandalia.valorant.map.presentation.map_list.components.ValoMapListItem
import com.mohitmandalia.valorant.ui.theme.ValorantBlack

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun ValoMapListScreen(
    navController: NavController,
    viewModel: ValoMapListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = ValorantBlack
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            items(state.valoMap) { map ->
                ValoMapListItem(
                    valoMap = map,
                    onItemClick = {
                        navController.navigate(
                            Screen.MapDetailScreen.route + "/${map.uuid}"
                        )
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        if(state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }


}