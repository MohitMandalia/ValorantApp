package com.mohitmandalia.valorant.map.presentation.map_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.valorant.core.domain.util.Resource
import com.mohitmandalia.valorant.core.util.Constants.MAP_UUID
import com.mohitmandalia.valorant.map.domain.use_case.ValoMapsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */
@HiltViewModel
class ValoMapDetailViewModel @Inject constructor(
    val valoMapsUseCase: ValoMapsUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ValoMapDetailState())
    val state: State<ValoMapDetailState> = _state

    init {
        savedStateHandle.get<String>(MAP_UUID)?.let { mapUuid ->
            getMapByUuid(mapUuid)
        }
    }

    private fun getMapByUuid(mapUuid: String) {
        valoMapsUseCase.getMapByUuid(mapUuid).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = ValoMapDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ValoMapDetailState(valoMap = result.data)
                }
                is Resource.Error -> {
                    _state.value = ValoMapDetailState(error = result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }

}