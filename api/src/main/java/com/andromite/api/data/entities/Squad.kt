package com.andromite.api.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Squad(
    @Json(name = "squad_loosed")
    val squadLoosed: Int,
    @Json(name = "squad_name")
    val squadName: String,
    @Json(name = "squad_played")
    val squadPlayed: Int,
    @Json(name = "squad_points")
    val squadPoints: Int,
    @Json(name = "squad_position")
    val squadPosition: Int,
    @Json(name = "squad_tie")
    val squadTie: Int,
    @Json(name = "squad_winned")
    val squadWinned: Int
)