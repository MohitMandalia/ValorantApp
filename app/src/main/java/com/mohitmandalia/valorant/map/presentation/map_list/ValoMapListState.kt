package com.mohitmandalia.valorant.map.presentation.map_list

import com.mohitmandalia.valorant.map.domain.model.ValoMap

/**
 *   Created by Mohit Mandalia
 */

data class ValoMapListState(
    val isLoading: Boolean = false,
    val valoMap: List<ValoMap> = emptyList(),
    val error: String = ""
)
