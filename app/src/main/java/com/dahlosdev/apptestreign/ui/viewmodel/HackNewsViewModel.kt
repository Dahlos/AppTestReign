package com.dahlosdev.apptestreign.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.GetHackNews
import com.dahlosdev.apptestreign.domain.GetHackNewsByPage
import kotlinx.coroutines.launch

class HackNewsViewModel : ViewModel() {

    val hackNewsModel = MutableLiveData<HackNewsModel>()

    var getHackNews = GetHackNews()
    var getHackNewsByPage = GetHackNewsByPage()

    fun onCreate() {
        viewModelScope.launch {
            val result = getHackNews()

            if (result != null) {
                hackNewsModel.postValue(result!!)
            }
        }
    }

    fun getHackNewsPage(page:Int) {
        viewModelScope.launch {
            val result = getHackNewsByPage(page)

            if (result != null) {
                hackNewsModel.postValue(result!!)
            }
        }
    }
}