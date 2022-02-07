package com.dahlosdev.apptestreign.domain

import com.dahlosdev.apptestreign.data.HackNewsRepository
import com.dahlosdev.apptestreign.data.database.entities.toDatabase
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.model.HackNews
import javax.inject.Inject

class GetHackNews @Inject constructor(private val repository: HackNewsRepository) {
    suspend operator fun invoke(): List<HackNews> {
        val hackNews = repository.getAllHackNewsFromApi()

        return if (hackNews.isNotEmpty()) {
            repository.clearHackNews()
            repository.insertHackNewsToDatabase(hackNews.map { it.toDatabase() })
            hackNews
        } else {
            repository.getAllHackNewsFromDatabase()
        }


    }
}