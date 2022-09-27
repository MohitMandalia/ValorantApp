package com.mohitmandalia.valorant.agent.data.repository

import com.mohitmandalia.valorant.agent.data.remote.dto.AgentWrapperDto
import com.mohitmandalia.valorant.agent.data.remote.dto.AllAgentsWrapperDto
import com.mohitmandalia.valorant.agent.domain.repository.AgentRepository
import com.mohitmandalia.valorant.core.data.remote.ValorantApi
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */
class AgentRepositoryImpl @Inject constructor(
    private val api: ValorantApi
): AgentRepository {

    override suspend fun getAgents(): AllAgentsWrapperDto {
        return api.getAgents()
    }

    override suspend fun getAgentByUuid(uuid: String): AgentWrapperDto {
        return api.getAgentByUuid(uuid)
    }
}