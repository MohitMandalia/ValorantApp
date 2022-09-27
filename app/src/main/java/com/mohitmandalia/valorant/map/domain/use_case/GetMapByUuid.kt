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
class GetMapByUuid @Inject constructor(
    private val repository: MapRepository
) {
     operator fun invoke(mapUuid: String): Flow<Resource<ValoMap>> = flow {
         try {
            emit(Resource.Loading())
            val response = repository.getMapByUuid(mapUuid)
            if(response.status != 200) {
                emit(Resource.Error("Http error code ${response.status}"))
                return@flow
            }
            val map = response.data.toValoMap()
            emit(Resource.Success(map))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Server not reachable please check your internet connection"))
        }
    }
}