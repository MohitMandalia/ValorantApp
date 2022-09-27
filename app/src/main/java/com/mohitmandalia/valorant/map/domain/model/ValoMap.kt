package com.mohitmandalia.valorant.map.domain.model

import com.mohitmandalia.valorant.map.data.remote.dto.Callout

/**
 *   Created by Mohit Mandalia
 */
data class ValoMap(
    val callouts: List<Callout>? = null,
    val coordinates: String,
    val displayIcon: String? = null,
    val displayName: String,
    val listViewIcon: String,
    val splash: String,
    val uuid: String
)