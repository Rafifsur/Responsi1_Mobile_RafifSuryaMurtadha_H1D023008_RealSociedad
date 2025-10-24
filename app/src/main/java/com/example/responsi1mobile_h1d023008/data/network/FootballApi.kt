package com.example.responsi1mobile_h1d023008.data.network

import com.example.responsi1mobile_h1d023008.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApi {
    @GET("teams/{id}")
    suspend fun getTeamById(@Path("id") id: Int): Response<TeamResponse>
}
