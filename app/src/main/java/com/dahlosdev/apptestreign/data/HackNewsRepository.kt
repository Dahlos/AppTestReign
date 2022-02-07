package com.dahlosdev.apptestreign.data

import com.dahlosdev.apptestreign.data.database.dao.HackNewsDao
import com.dahlosdev.apptestreign.data.database.entities.HackNewsEntity
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.data.network.HackNewsService
import com.dahlosdev.apptestreign.domain.model.HackNews
import com.dahlosdev.apptestreign.domain.model.toDomain
import javax.inject.Inject

class HackNewsRepository @Inject constructor(
    private val api: HackNewsService,
    private val hackNewsDao: HackNewsDao
) {

    suspend fun getAllHackNewsFromApi(): List<HackNews> {
        val response = api.getHackNews()
        return response.map { it.toDomain() }
    }

    suspend fun getAllHackNewsFromDatabase(): List<HackNews> {
        val response = hackNewsDao.getHackNews()
        return response.map { it.toDomain() }
    }

    suspend fun insertHackNewsToDatabase(hackNews: List<HackNewsEntity>) {
        hackNewsDao.insertAll(hackNews)
    }

    suspend fun clearHackNews() {
        hackNewsDao.deleteAllHackNews()
    }
}