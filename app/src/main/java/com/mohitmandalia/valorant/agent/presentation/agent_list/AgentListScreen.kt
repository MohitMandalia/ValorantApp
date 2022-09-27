package com.mohitmandalia.valorant.agent.presentation.agent_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mohitmandalia.valorant.agent.presentation.agent_list.components.AgentListItem
import com.mohitmandalia.valorant.core.util.Screen
import com.mohitmandalia.valorant.ui.theme.ValorantBlack

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun AgentListScreen(
    navController: NavController,
    viewModel: AgentListViewModel = hiltViewModel()
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ){
            items(state.agents) { agent ->
                AgentListItem(
                    agent = agent,
                    onItemClick = {
                        navController.navigate(
                            Screen.AgentDetailScreen.route + "/${agent.uuid}"
                        )
                    }
                )
            }
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if(state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
    
}