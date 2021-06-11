package com.andromite.footballsquad.repository

import com.andromite.api.data.FootballClient
import com.andromite.api.data.entities.Squad

object MainRepository {

    val api = FootballClient.api

    suspend fun getSquads(league:String) = api.getSquads(league).body()
    suspend fun getScorer(league:String) = api.getScorer(league).body()

}