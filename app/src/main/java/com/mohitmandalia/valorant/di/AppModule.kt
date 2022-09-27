package com.mohitmandalia.valorant.di

import com.mohitmandalia.valorant.agent.data.repository.AgentRepositoryImpl
import com.mohitmandalia.valorant.agent.domain.repository.AgentRepository
import com.mohitmandalia.valorant.agent.domain.use_case.AgentUseCases
import com.mohitmandalia.valorant.agent.domain.use_case.GetAgentByUuidUseCase
import com.mohitmandalia.valorant.agent.domain.use_case.GetAgentsUseCase
import com.mohitmandalia.valorant.core.data.remote.ValorantApi
import com.mohitmandalia.valorant.core.util.Constants.BASE_URL
import com.mohitmandalia.valorant.map.data.repository.MapRepositoryImpl
import com.mohitmandalia.valorant.map.domain.repository.MapRepository
import com.mohitmandalia.valorant.map.domain.use_case.GetMapByUuid
import com.mohitmandalia.valorant.map.domain.use_case.GetMapsUseCase
import com.mohitmandalia.valorant.map.domain.use_case.ValoMapsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 *   Created by Mohit Mandalia
 *
 *   This object is a Module which helps us provide all the singelton objects from mentioned functions as a dependency to other classes
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // This method provides Valorant Api object
    @Provides
    @Singleton
    fun provideValorantApi(): ValorantApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ValorantApi::class.java)
    }

    // This method provides Agent Repository Object
    @Provides
    @Singleton
    fun provideAgentRepository(api: ValorantApi): AgentRepository = AgentRepositoryImpl(api)

    // This method provides AgentUserCases Object
    @Provides
    @Singleton
    fun provideAgentUseCases(repository: AgentRepository): AgentUseCases {
        return AgentUseCases(
            getAgentByUuidUseCase = GetAgentByUuidUseCase(repository),
            getAgentsUseCase = GetAgentsUseCase(repository)
        )
    }

    // This method provides Map Repository Object
    @Provides
    @Singleton
    fun provideMapRepository(api: ValorantApi): MapRepository = MapRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideMapsUseCases(repository: MapRepository): ValoMapsUseCases {
        return ValoMapsUseCases(
            getMapsUseCase = GetMapsUseCase(repository),
            getMapByUuid = GetMapByUuid(repository)
        )
    }

}