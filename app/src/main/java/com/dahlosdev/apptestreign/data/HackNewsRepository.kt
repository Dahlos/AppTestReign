package com.dahlosdev.apptestreign.data

import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.data.network.HackNewsService
import javax.inject.Inject

class HackNewsRepository @Inject constructor(private val api: HackNewsService) {

    suspend fun getAllHackNews(): HackNewsModel {
        val response = api.getHackNews()
        HackNewsProvider.hackNews = response
        return response
    }

    suspend fun getAllHackNewsOffline(): HackNewsModel {
        TODO("OBTENER EL LISTADO DESDE ROOM")
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