package com.dahlosdev.apptestreign.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.GetHackNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HackNewsViewModel @Inject constructor(
    private val getHackNews: GetHackNews
) : ViewModel() {

    var hackNewsModel = MutableLiveData<HackNewsModel>()
    val isLoading = MutableLiveData<Boolean>()
    val isRefreshing = MutableLiveData<Boolean>()

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