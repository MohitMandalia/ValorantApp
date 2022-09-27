package com.mohitmandalia.valorant.map.domain.use_case

import com.mohitmandalia.valorant.core.domain.util.Resource
import com.mohitmandalia.valorant.map.data.remote.dto.toValoMap
import com.mohitmandalia.valorant.map.domain.model.ValoMap
import com.mohitmandalia.valorant.map.domain.repository.MapRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */
class GetMapsUseCase @Inject constructor(
    private val repository: MapRepository
) {
     operator fun invoke(): Flow<Resource<List<ValoMap>>> = flow {

        try {
            emit(Resource.Loading())
            val response = repository.getMaps()
            if(response.status != 200) {
                emit(Resource.Error("Http error code ${response.status}"))
                return@flow
            }
            val valoMaps = response.data.map { it.toValoMap() }
            emit(Resource.Success(valoMaps))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }
        catch (e: IOException) {
            emit(Resource.Error("Server not reachable please check your internet connection"))
        }

    }
}