package com.mohitmandalia.valorant.agent.data.remote.dto

data class AllAgentsWrapperDto(
    val `data`: List<AgentDto>,
    val status: Int
)

fun AllAgentsWrapperDto.toAgentDto(): List<AgentDto> {
    return data
}