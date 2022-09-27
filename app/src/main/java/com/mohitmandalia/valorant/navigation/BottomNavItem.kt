package com.mohitmandalia.valorant.navigation

import com.mohitmandalia.valorant.R
import com.mohitmandalia.valorant.core.util.Constants
import com.mohitmandalia.valorant.core.util.Screen

sealed class BottomNavItem(
    val title: String,
    val image: Int,
    val route: String
) {
    object Agents : BottomNavItem(
        title = Constants.CATEGORY_AGENTS,
        image = R.drawable.ic_agent,
        route = Screen.AgentsScreen.route
    )

    object Maps : BottomNavItem(
        title = Constants.CATEGORY_MAPS,
        image = R.drawable.ic_map,
        route = Screen.MapsScreen.route
    )
}