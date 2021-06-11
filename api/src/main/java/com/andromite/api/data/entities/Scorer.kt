package com.andromite.api.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Scorer(
    @Json(name = "player_goals")
    val playerGoals: Int,
    @Json(name = "player_name")
    val playerName: String,
    @Json(name = "player_penalties")
    val playerPenalties: Int,
    @Json(name = "player_position")
    val playerPosition: Int,
    @Json(name = "player_role")
    val playerRole: String,
    @Json(name = "player_squad")
    val playerSquad: String
)