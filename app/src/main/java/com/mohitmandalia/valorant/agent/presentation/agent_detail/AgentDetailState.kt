package com.mohitmandalia.valorant.agent.presentation.agent_detail

import com.mohitmandalia.valorant.agent.domain.model.Agent

/**
 *   Created by Mohit Mandalia
 */
data class AgentDetailState(
    val isLoading: Boolean = false,
    val agent: Agent? = null,
    val error: String = ""
)