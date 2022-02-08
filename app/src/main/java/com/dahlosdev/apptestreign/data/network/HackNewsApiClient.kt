package com.dahlosdev.apptestreign.data.network

import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.data.model.HackNewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HackNewsApiClient {
    @GET("search_by_date?query=mobile")
    suspend fun getAllHackNews(): Response<HackNewsPage>

    @GET("search_by_date?query=mobile")
    suspend fun getHackNewsByPage(@Query("page") page: Int): Response<HackNewsModel>
}