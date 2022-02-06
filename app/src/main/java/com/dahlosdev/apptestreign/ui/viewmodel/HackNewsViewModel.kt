package com.dahlosdev.apptestreign.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.GetHackNews
import kotlinx.coroutines.launch

class HackNewsViewModel : ViewModel() {

    val hackNewsModel = MutableLiveData<HackNewsModel>()

    var getHackNews = GetHackNews()

    fun onCreate() {
        viewModelScope.launch {
            val result = getHackNews()

            if (result != null) {
                hackNewsModel.postValue(result!!)
            }
        }
    }
}