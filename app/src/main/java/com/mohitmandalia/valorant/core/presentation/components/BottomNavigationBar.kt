package com.mohitmandalia.valorant.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mohitmandalia.valorant.navigation.BottomNavItem
import com.mohitmandalia.valorant.ui.theme.ValorantLightBlack
import com.mohitmandalia.valorant.ui.theme.ValorantRed
import com.mohitmandalia.valorant.ui.theme.ValorantWhite

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun BottomNavigationBar(
    navController: NavController
) {

    val navigationItems = listOf(
        BottomNavItem.Agents,
        BottomNavItem.Maps
    )
    AnimatedVisibility(
        visible = true
    ) {
        BottomNavigation(
            backgroundColor = ValorantLightBlack
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            navigationItems.forEach { navItems ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = navItems.image),
                            contentDescription = "Navigation Icon"
                        )
                    },
                    label = {
                            Text(text = navItems.title)
                    },
                    alwaysShowLabel = false,
                    selected = currentRoute == navItems.route,
                    onClick = {
                        navController.navigate(navItems.route)
                    },
                    selectedContentColor = ValorantRed,
                    unselectedContentColor = ValorantWhite
                )
            }
        }
    }
}