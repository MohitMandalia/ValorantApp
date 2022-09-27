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
 *   This class get is a use case to get a single agent by uuid
 */
class GetAgentByUuidUseCase @Inject constructor(
    private val repository: AgentRepository
) {
    operator fun invoke(uuid: String): Flow<Resource<Agent>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getAgentByUuid(uuid)
            if(response.status != 200) {
                emit(Resource.Error("Http error code ${response.status}"))
                return@flow
            }
            val agent = response.data.toAgent()
            emit(Resource.Success(agent))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Server not reachable please check your internet connection"))
        }
    }
}