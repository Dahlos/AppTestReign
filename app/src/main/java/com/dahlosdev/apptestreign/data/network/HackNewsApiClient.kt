package com.dahlosdev.apptestreign.data.network

import com.dahlosdev.apptestreign.data.model.HackNewsModel
import retrofit2.Response
import retrofit2.http.GET

interface HackNewsApiClient {
    @GET("search_by_date?query=mobile")
//    suspend fun getAllHackNews(): Response<List<HackNewsModel>>
    suspend fun getAllHackNews(): Response<HackNewsModel>
}