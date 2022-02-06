package com.dahlosdev.apptestreign.data

import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.data.network.HackNewsService

class HackNewsRepository {

    private val api = HackNewsService()

    //    suspend fun getAllHackNews(): List<HackNewsModel> {
    suspend fun getAllHackNews(): HackNewsModel {
        val response = api.getHackNews()
        HackNewsProvider.hackNews = response
        return response
    }

    suspend fun getHackNewsByPage(page: Int): HackNewsModel {
        val response = api.getHackNewsByPage(page)
        HackNewsProvider.hackNews = response
        return response
    }
}