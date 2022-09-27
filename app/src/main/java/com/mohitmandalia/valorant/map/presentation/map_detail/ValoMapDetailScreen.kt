package com.mohitmandalia.valorant.map.presentation.map_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mohitmandalia.valorant.map.presentation.map_detail.components.ValoMapDetailItem

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun ValoMapDetailScreen(
    viewModel: ValoMapDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.valoMap?.let { map ->
            ValoMapDetailItem(valoMap = map)
        }
    }

}