package com.mohitmandalia.valorant.map.presentation.map_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.valorant.core.domain.util.Resource
import com.mohitmandalia.valorant.map.domain.use_case.ValoMapsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

@HiltViewModel
class ValoMapListViewModel @Inject constructor(
    private val valoMapsUseCases: ValoMapsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ValoMapListState())
    val state: State<ValoMapListState> = _state

    init {
        getMaps()
    }

    private fun getMaps() {
        valoMapsUseCases.getMapsUseCase().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = ValoMapListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ValoMapListState(valoMap = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ValoMapListState(error = result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}