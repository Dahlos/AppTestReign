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
    val isLoading = MutableLiveData<Boolean>()
    val currentPageHackNews = MutableLiveData<Int>()

    var getHackNews = GetHackNews()
    var getHackNewsByPage = GetHackNewsByPage()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getHackNews()

            if (result != null) {
                hackNewsModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getHackNewsPage(page: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getHackNewsByPage(page)

            if (result != null) {
                hackNewsModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}