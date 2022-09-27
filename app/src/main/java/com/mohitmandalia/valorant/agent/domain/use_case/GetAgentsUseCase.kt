package com.mohitmandalia.valorant.agent.domain.use_case

import com.mohitmandalia.valorant.agent.data.remote.dto.toAgent
import com.mohitmandalia.valorant.agent.domain.model.Agent
import com.mohitmandalia.valorant.agent.domain.repository.AgentRepository
import com.mohitmandalia.valorant.core.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 *
 *   This class is a use case which gets all the agents from the api by calling repository
 */
class GetAgentsUseCase @Inject constructor(
    private val repository: AgentRepository
) {
    operator fun invoke(): Flow<Resource<List<Agent>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getAgents()
            if(response.status != 200) {
                emit(Resource.Error("Http error code ${response.status}"))
                return@flow
            }
            val agents = response.data.map { it.toAgent() }
            emit(Resource.Success(agents))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Server not reachable please check your internet connection"))
        }
    }
}