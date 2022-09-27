package com.mohitmandalia.valorant.agent.domain.repository

import com.mohitmandalia.valorant.agent.data.remote.dto.AgentWrapperDto
import com.mohitmandalia.valorant.agent.data.remote.dto.AllAgentsWrapperDto

/**
 *   Created by Mohit Mandalia
 */
interface AgentRepository {

    suspend fun getAgents(): AllAgentsWrapperDto

    suspend fun getAgentByUuid(uuid: String): AgentWrapperDto
}