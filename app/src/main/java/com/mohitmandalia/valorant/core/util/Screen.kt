package com.mohitmandalia.valorant.core.util

/**
 *   Created by Mohit Mandalia
 */

const val agent_list = "agent_list"
const val agent_detail = "agent_detail"
const val map_list = "map_list"
const val map_detail = "map_detail"

sealed class Screen(val route: String) {
    object AgentsScreen: Screen(agent_list)
    object AgentDetailScreen: Screen(agent_detail)
    object MapsScreen: Screen(map_list)
    object MapDetailScreen: Screen(map_detail)
}
