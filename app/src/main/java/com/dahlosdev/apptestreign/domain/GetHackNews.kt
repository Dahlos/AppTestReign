package com.dahlosdev.apptestreign.domain

import com.dahlosdev.apptestreign.data.HackNewsRepository
import com.dahlosdev.apptestreign.data.database.entities.toDatabase
import com.dahlosdev.apptestreign.domain.model.HackNews
import com.dahlosdev.apptestreign.core.ConnectionInternet
import javax.inject.Inject

class GetHackNews @Inject constructor(
    private val repository: HackNewsRepository,
    private val connectionInternet: ConnectionInternet
) {
    suspend operator fun invoke(): List<HackNews> {

        if (connectionInternet.checkForInternet()) {
            val hackNews = repository.getAllHackNewsFromApi()
            return if (hackNews.isNotEmpty()) {
                repository.clearHackNews()
                repository.insertHackNewsToDatabase(hackNews.map { it.toDatabase() })
                hackNews
            } else {
                repository.getAllHackNewsFromDatabase()
            }
        } else {
            if (repository.getAllHackNewsFromDatabase()
                    .isNotEmpty()
            ) return repository.getAllHackNewsFromDatabase()
        }

        return emptyList()
    }
}