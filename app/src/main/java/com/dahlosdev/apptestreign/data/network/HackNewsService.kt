package com.dahlosdev.apptestreign.data.network

import com.dahlosdev.apptestreign.core.RetrofitHelper
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class HackNewsService {

    private val retrofit = RetrofitHelper.getRetrofit()

//    suspend fun getHackNews(): List<HackNewsModel> {
    suspend fun getHackNews(): HackNewsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HackNewsApiClient::class.java).getAllHackNews()
            response.body()!!
        }
    }
}