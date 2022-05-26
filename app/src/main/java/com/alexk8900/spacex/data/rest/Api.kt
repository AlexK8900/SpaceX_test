package com.alexk8900.spacex.data.rest

import com.alexk8900.spacex.data.rest.dto.Crew
import com.alexk8900.spacex.data.rest.dto.Request
import com.alexk8900.spacex.data.rest.dto.ResponseLaunchesDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("/v4/launches/query")
    suspend fun getLaunches(@Body body: Request) : ResponseLaunchesDto

    @GET("/v4/crew/{id}")
    suspend fun getCrew(@Path("id") id: String?): Crew
}