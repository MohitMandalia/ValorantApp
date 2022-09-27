package com.mohitmandalia.valorant.map.data.repository

import com.mohitmandalia.valorant.core.data.remote.ValorantApi
import com.mohitmandalia.valorant.map.data.remote.dto.AllValoMapWrapperDto
import com.mohitmandalia.valorant.map.data.remote.dto.ValoMapWrapperDto
import com.mohitmandalia.valorant.map.domain.repository.MapRepository
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */
class MapRepositoryImpl @Inject constructor(
    private val api: ValorantApi
) : MapRepository {

    override suspend fun getMaps(): AllValoMapWrapperDto {
        return api.getMaps()
    }

    override suspend fun getMapByUuid(mapUuid: String): ValoMapWrapperDto {
        return api.getMapByUuid(mapUuid)
    }
}