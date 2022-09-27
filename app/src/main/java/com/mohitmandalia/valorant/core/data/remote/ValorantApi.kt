package com.mohitmandalia.valorant.core.data.remote

import com.mohitmandalia.valorant.agent.data.remote.dto.AgentWrapperDto
import com.mohitmandalia.valorant.agent.data.remote.dto.AllAgentsWrapperDto
import com.mohitmandalia.valorant.map.data.remote.dto.AllValoMapWrapperDto
import com.mohitmandalia.valorant.map.data.remote.dto.ValoMapWrapperDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *   Created by Mohit Mandalia
 */
interface ValorantApi {

    @GET("/v1/agents?isPlayableCharacter=true")
    suspend fun getAgents(): AllAgentsWrapperDto

    @GET("/v1/agents/{uuid}")
    suspend fun getAgentByUuid(@Path("uuid") uuid: String): AgentWrapperDto

    @GET("v1/maps")
    suspend fun getMaps(): AllValoMapWrapperDto

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUuid(@Path("mapUuid") mapUuid: String): ValoMapWrapperDto
}