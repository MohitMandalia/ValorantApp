package com.mohitmandalia.valorant.agent.presentation.agent_detail.components

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mohitmandalia.valorant.agent.domain.model.Agent
import com.mohitmandalia.valorant.ui.theme.ValorantLightBlack
import com.mohitmandalia.valorant.ui.theme.ValorantRed
import com.mohitmandalia.valorant.ui.theme.ValorantSuperLightBlack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun AgentDetailItem(
    agent: Agent
) {

    val voiceLine = agent.voiceLine.mediaList.get(0).wave
    val scope = rememberCoroutineScope()

    DisposableEffect(voiceLine) {
        val mediaPlayer = MediaPlayer()
        scope.launch(Dispatchers.Default) {
            mediaPlayer.apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(voiceLine)
                prepare() // might take long! (for buffering, etc)
                start()
            }
        }

        onDispose {
            mediaPlayer.stop()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    )
                )
                .background(MaterialTheme.colors.primary),
            contentAlignment = Center
        ) {
            agent.background?.let { background ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(background)
                        .crossfade(true)
                        .crossfade(500)
                        .build(),
                    contentDescription = "Agent Background",
                    modifier = Modifier.fillMaxSize(),
                    alpha = 0.5f
                )
            }

            Column {
                agent.fullPortrait?.let { portrait ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(portrait)
                            .crossfade(true)
                            .crossfade(500)
                            .build(),
                        contentDescription = "Agent Full Portrait"
                    )
                }

                Spacer(modifier = Modifier.height(60.dp))


                agent.role?.let {
                    Text(
                        text = it.displayName,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(ValorantLightBlack)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 10.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Description",
                    color = ValorantRed,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))


                Text(
                    text = agent.description ?: "No Description Found",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(ValorantLightBlack)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 10.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Abilities",
                    color = ValorantRed,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                agent.abilities.forEach { ability ->

                    AbilityItem(
                        abilityDisplayIcon = ability.displayIcon,
                        abilityDisplayName = ability.displayName,
                        abilityDescription = ability.description,
                        context = LocalContext.current
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                }

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun AbilityItem(
    abilityDisplayIcon: String = "",
    abilityDisplayName: String,
    abilityDescription: String,
    context: Context
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(ValorantSuperLightBlack)
            .padding(horizontal = 10.dp, vertical = 20.dp)

    ) {
        Box(
            modifier = Modifier
                .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp))
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ValorantLightBlack)
                .padding(10.dp),
            contentAlignment = Center
        ) {

            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(abilityDisplayIcon)
                    .crossfade(true)
                    .crossfade(500)
                    .build(),
                contentDescription = "Ability Display Icon"
            )

        }

        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = abilityDisplayName,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = abilityDescription,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }
    }
}

