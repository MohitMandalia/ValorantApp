package com.mohitmandalia.valorant.agent.presentation.agent_list.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.mohitmandalia.valorant.agent.domain.model.Agent

/**
*   Created by Mohit Mandalia
*/

@Composable
fun AgentListItem(
    agent: Agent,
    onItemClick: (Agent) -> Unit
) {

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(8.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable {
                onItemClick(agent)
            },
        contentAlignment = Alignment.BottomCenter
    ) {
//        Box(
//            modifier = Modifier
//                .shadow(
//                    elevation = 2.dp,
//                    shape = RoundedCornerShape(10.dp)
//                )
//                .fillMaxWidth()
//                .height(40.dp)
//                .clip(RoundedCornerShape(10.dp))
//                .background(MaterialTheme.colors.primary)
//        )
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(agent.displayIcon)
                .crossfade(true)
                .crossfade(500)
                .build(),
            contentDescription = agent.displayName,
            modifier = Modifier
                .fillMaxSize()
        )

        Text(
            text = agent.displayName,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.fillMaxWidth()
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