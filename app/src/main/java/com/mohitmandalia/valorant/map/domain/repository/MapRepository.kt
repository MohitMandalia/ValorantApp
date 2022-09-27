package com.mohitmandalia.valorant.map.domain.repository

import com.mohitmandalia.valorant.map.data.remote.dto.AllValoMapWrapperDto
import com.mohitmandalia.valorant.map.data.remote.dto.ValoMapWrapperDto

/**
 *   Created by Mohit Mandalia
 */
interface MapRepository {


    suspend fun getMaps(): AllValoMapWrapperDto


    suspend fun getMapByUuid(mapUuid: String): ValoMapWrapperDto

}