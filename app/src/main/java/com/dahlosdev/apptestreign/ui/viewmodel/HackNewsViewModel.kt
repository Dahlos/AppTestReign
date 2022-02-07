package com.dahlosdev.apptestreign.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.GetHackNews
import kotlinx.coroutines.launch

class HackNewsViewModel : ViewModel() {

    var hackNewsModel = MutableLiveData<HackNewsModel>()
    val isLoading     = MutableLiveData<Boolean>()
    val isRefreshing  = MutableLiveData<Boolean>()

    // USE CASES
    var getHackNews   = GetHackNews()

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

    fun onRefresh() {
        viewModelScope.launch {
            isRefreshing.postValue(true)
            val result = getHackNews()

            if (result != null) {
                hackNewsModel.postValue(result!!)
                isRefreshing.postValue(false)
            }
        }
    }

}