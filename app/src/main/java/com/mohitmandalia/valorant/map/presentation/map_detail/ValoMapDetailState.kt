package com.mohitmandalia.valorant.map.presentation.map_detail

import com.mohitmandalia.valorant.map.domain.model.ValoMap

/**
 *   Created by Mohit Mandalia
 */
data class ValoMapDetailState(
    val isLoading: Boolean = false,
    val valoMap: ValoMap? = null,
    val error: String = ""
)