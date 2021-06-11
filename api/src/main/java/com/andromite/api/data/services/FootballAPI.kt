package com.andromite.api.data.services

import com.andromite.api.data.entities.Scorer
import com.andromite.api.data.entities.Squad
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballAPI {

    @GET("{league}/squads")
    suspend fun getSquads(@Path("league") league: String? ) :Response<List<Squad>>

    @GET("{league}/scorers")
    suspend fun getScorer(@Path("league") league : String?) :Response<List<Scorer>>

}