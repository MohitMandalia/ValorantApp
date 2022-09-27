package com.mohitmandalia.valorant.map.data.remote.dto

import com.mohitmandalia.valorant.map.domain.model.ValoMap

data class ValoMapDto(
    val assetPath: String,
    val callouts: List<Callout>? = null,
    val coordinates: String,
    val displayIcon: String? = null,
    val displayName: String,
    val listViewIcon: String,
    val mapUrl: String,
    val splash: String,
    val uuid: String,
    val xMultiplier: String,
    val xScalarToAdd: String,
    val yMultiplier: String,
    val yScalarToAdd: String
)

fun ValoMapDto.toValoMap(): ValoMap {
    return ValoMap(
        callouts = callouts,
        coordinates = coordinates,
        uuid = uuid,
        displayName = displayName,
        displayIcon = displayIcon,
        listViewIcon = listViewIcon,
        splash = splash
    )
}