package com.mohitmandalia.valorant.map.presentation.map_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.mohitmandalia.valorant.map.domain.model.ValoMap

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun ValoMapListItem(
    valoMap: ValoMap,
    onItemClick: (ValoMap) -> Unit
) {

    var mapUrl = valoMap.splash

    Box(
        modifier = Modifier
            .aspectRatio(1.5f)
            .clip(
                RoundedCornerShape(10.dp)
            ).clickable {
                onItemClick(valoMap)
            },
        contentAlignment = Alignment.Center
    ) {
        if(mapUrl.isNullOrEmpty()) {
            mapUrl = ""
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(mapUrl)
                .crossfade(true)
                .crossfade(500)
                .transformations(RoundedCornersTransformation(10f))
                .build(),
            contentDescription = valoMap.displayName,
            modifier = Modifier
                .fillMaxSize()
        )
        Text(
            text = valoMap.displayName,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Gray
                        )
                    )
                )
        )
    }
}