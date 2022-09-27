package com.mohitmandalia.valorant.agent.presentation.agent_list


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.valorant.agent.domain.use_case.AgentUseCases
import com.mohitmandalia.valorant.core.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val agentUseCases: AgentUseCases
): ViewModel() {

    private val _state = mutableStateOf(AgentListState())
    val state: State<AgentListState> = _state

    init {
        getAgents()
    }

    // sets data to our _state object
    private fun getAgents() {
        agentUseCases.getAgentsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = AgentListState(agents = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AgentListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = AgentListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}