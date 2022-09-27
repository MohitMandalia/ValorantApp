package com.mohitmandalia.valorant.agent.domain.model

import com.mohitmandalia.valorant.agent.data.remote.dto.Ability
import com.mohitmandalia.valorant.agent.data.remote.dto.Role
import com.mohitmandalia.valorant.agent.data.remote.dto.VoiceLine

/**
 *   Created by Mohit Mandalia
 */
data class Agent(
    val abilities: List<Ability>,
    val assetPath: String?,
    val background: String?,
    val backgroundGradientColors: List<String>,
    val characterTags: Any?,
    val description: String?,
    val displayIcon: String?,
    val displayIconSmall: String?,
    val displayName: String,
    val fullPortrait: String?,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String?,
    val role: Role?,
    val uuid: String,
    val voiceLine: VoiceLine
)
