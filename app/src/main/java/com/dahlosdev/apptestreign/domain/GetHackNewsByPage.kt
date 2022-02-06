package com.dahlosdev.apptestreign.domain

import com.dahlosdev.apptestreign.data.HackNewsRepository
import com.dahlosdev.apptestreign.data.model.HackNewsModel

class GetHackNewsByPage {

    private val repository = HackNewsRepository()

    //    suspend operator fun invoke(): List<HackNewsModel>? = repository.getAllHackNews()
    suspend operator fun invoke(page: Int): HackNewsModel? = repository.getHackNewsByPage(page)

}