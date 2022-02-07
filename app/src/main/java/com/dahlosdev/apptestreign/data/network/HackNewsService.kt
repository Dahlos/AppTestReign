package com.dahlosdev.apptestreign.data.network

import com.dahlosdev.apptestreign.core.RetrofitHelper
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class HackNewsService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getHackNews(): HackNewsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HackNewsApiClient::class.java).getAllHackNews()
            response.body()!!
        }
    }

    suspend fun getHackNewsByPage(page: Int): HackNewsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HackNewsApiClient::class.java).getHackNewsByPage(page)
            response.body()!!
        }
    }
}