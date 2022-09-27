package com.mohitmandalia.valorant.agent.presentation.agent_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mohitmandalia.valorant.agent.presentation.agent_detail.components.AgentDetailItem
import com.mohitmandalia.valorant.ui.theme.ValorantRed
import kotlinx.coroutines.launch

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun AgentDetailScreen(
    viewModel: AgentDetaiViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()
    SideEffect {
        scope.launch {
            systemUiController.setStatusBarColor(
                color = ValorantRed
            )
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        state.agent?.let {
            AgentDetailItem(agent = state.agent)
        }
    }
}