package com.mohitmandalia.valorant.map.presentation.map_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mohitmandalia.valorant.map.domain.model.ValoMap

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun ValoMapDetailItem(
    valoMap: ValoMap
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
//                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            valoMap.displayIcon?.let {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(valoMap.displayIcon)
                        .crossfade(true)
                        .crossfade(500)
                        .build(),
                    contentDescription = valoMap.displayName
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = valoMap.displayName,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}