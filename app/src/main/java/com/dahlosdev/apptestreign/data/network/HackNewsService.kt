package com.dahlosdev.apptestreign.data.network

import com.dahlosdev.apptestreign.data.model.HackNewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HackNewsService @Inject constructor(private val api: HackNewsApiClient) {

    suspend fun getHackNews(): HackNewsModel {
        return withContext(Dispatchers.IO) {
            val response = api.getAllHackNews()
            response.body()!!
        }
    }

    suspend fun getHackNewsByPage(page: Int): HackNewsModel {
        return withContext(Dispatchers.IO) {
            val response = api.getHackNewsByPage(page)
            response.body()!!
        }
    }
}