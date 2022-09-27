package com.mohitmandalia.valorant.agent.domain.use_case

/**
 *   Created by Mohit Mandalia
 *
 *   This class helps us wrap all the relevant use cases for Agent
 */

data class AgentUseCases(
    val getAgentByUuidUseCase: GetAgentByUuidUseCase,
    val getAgentsUseCase: GetAgentsUseCase
)