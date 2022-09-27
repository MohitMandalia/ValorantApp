package com.mohitmandalia.valorant.map.data.remote.dto

/**
 *   Created by Mohit Mandalia
 */
data class AllValoMapWrapperDto(
    val `data`: List<ValoMapDto>,
    val status: Int
)

fun AllValoMapWrapperDto.toValoMapDto(): List<ValoMapDto> {
    return data
}
