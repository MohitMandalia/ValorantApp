package com.mohitmandalia.valorant.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mohitmandalia.valorant.R
import com.mohitmandalia.valorant.ui.theme.ValorantBlack
import com.mohitmandalia.valorant.ui.theme.ValorantLightBlack

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun TopBarValo() {
    TopAppBar(
        backgroundColor = ValorantBlack,
        contentPadding = PaddingValues(vertical = 5.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.align(Alignment.Center)
                    .clip(RoundedCornerShape(5.dp))
                    .background(ValorantLightBlack)
                    .padding(5.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.valorant_logo),
                    contentDescription = "Valorant Logo",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
        }
    }
}