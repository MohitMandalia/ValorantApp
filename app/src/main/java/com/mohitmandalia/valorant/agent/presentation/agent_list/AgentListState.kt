package com.mohitmandalia.valorant.agent.presentation.agent_list

import com.mohitmandalia.valorant.agent.domain.model.Agent

/**
 *   Created by Mohit Mandalia
 */
data class AgentListState(
    val isLoading: Boolean = false,
    val agents: List<Agent> = emptyList(),
    val error: String = ""
)