package com.mohitmandalia.valorant.agent.data.remote.dto

import com.mohitmandalia.valorant.agent.domain.model.Agent

data class AgentDto(
    val abilities: List<Ability>,
    val assetPath: String,
    val background: String,
    val backgroundGradientColors: List<String>,
    val bustPortrait: Any,
    val characterTags: List<String>,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String,
    val fullPortraitV2: Any,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val killfeedPortrait: String,
    val role: Role,
    val uuid: String,
    val voiceLine: VoiceLine
)

fun AgentDto.toAgent(): Agent {
    return Agent(
        abilities = abilities,
        assetPath = assetPath,
        background = background,
        backgroundGradientColors = backgroundGradientColors,
        characterTags = characterTags,
        description = description,
        displayIcon = displayIcon,
        displayIconSmall = displayIconSmall,
        displayName = displayName,
        fullPortrait = fullPortrait,
        isBaseContent = isBaseContent,
        isFullPortraitRightFacing = isFullPortraitRightFacing,
        isPlayableCharacter = isPlayableCharacter,
        killfeedPortrait = killfeedPortrait,
        role = role,
        uuid = uuid,
        voiceLine = voiceLine
    )
}