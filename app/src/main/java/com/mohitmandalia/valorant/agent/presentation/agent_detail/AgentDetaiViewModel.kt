package com.mohitmandalia.valorant.agent.presentation.agent_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.valorant.agent.domain.use_case.AgentUseCases
import com.mohitmandalia.valorant.core.domain.util.Resource
import com.mohitmandalia.valorant.core.util.Constants.AGENT_UUID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

@HiltViewModel
class AgentDetaiViewModel @Inject constructor(
    private val agentUseCases: AgentUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(AgentDetailState())
    val state: State<AgentDetailState> = _state

    init {
        savedStateHandle.get<String>(AGENT_UUID)?.let { agentUuid ->
            getAgent(agentUuid)
        }
    }

    // sets data to our _state object
    private fun getAgent(uuid: String) {
        agentUseCases.getAgentByUuidUseCase(uuid).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = AgentDetailState(agent = result.data)
                }
                is Resource.Error -> {
                    _state.value = AgentDetailState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = AgentDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}