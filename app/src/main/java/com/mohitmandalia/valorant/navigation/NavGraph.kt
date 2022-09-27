package com.mohitmandalia.valorant.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mohitmandalia.valorant.agent.presentation.agent_detail.AgentDetailScreen
import com.mohitmandalia.valorant.agent.presentation.agent_list.AgentListScreen
import com.mohitmandalia.valorant.core.util.Constants
import com.mohitmandalia.valorant.core.util.Screen
import com.mohitmandalia.valorant.map.presentation.map_detail.ValoMapDetailScreen
import com.mohitmandalia.valorant.map.presentation.map_list.ValoMapListScreen

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = Screen.AgentsScreen.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {

        composable(
            route = Screen.AgentsScreen.route
        ) {
            AgentListScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.AgentDetailScreen.route + "/{${Constants.AGENT_UUID}}"
        ) {
            AgentDetailScreen()
        }

        composable(
            route = Screen.MapsScreen.route
        ) {
            ValoMapListScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.MapDetailScreen.route + "/{${Constants.MAP_UUID}}"
        ) {
            ValoMapDetailScreen()
        }


    }

}