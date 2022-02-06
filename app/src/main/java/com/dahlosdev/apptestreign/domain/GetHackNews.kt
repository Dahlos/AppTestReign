package com.dahlosdev.apptestreign.domain

import com.dahlosdev.apptestreign.data.HackNewsRepository
import com.dahlosdev.apptestreign.data.model.HackNewsModel

class GetHackNews {

    private val repository = HackNewsRepository()

    //    suspend operator fun invoke(): List<HackNewsModel>? = repository.getAllHackNews()
    suspend operator fun invoke(): HackNewsModel? = repository.getAllHackNews()

}