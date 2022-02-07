package com.dahlosdev.apptestreign.domain

import com.dahlosdev.apptestreign.data.HackNewsRepository
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import javax.inject.Inject

class GetHackNewsOffline@Inject constructor(private val repository: HackNewsRepository) {
    suspend operator fun invoke(): HackNewsModel? = repository.getAllHackNewsOffline()
}