package com.dahlosdev.apptestreign.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import com.dahlosdev.apptestreign.domain.GetHackNews
import com.dahlosdev.apptestreign.domain.model.HackNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HackNewsViewModel @Inject constructor(
    private val getHackNews: GetHackNews
) : ViewModel() {

    var hackNewsModel = MutableLiveData<List<HackNews>>()
    var deletedHackNewsModel = ArrayList<HackNews>()
    val isLoading = MutableLiveData<Boolean>()
    val isRefreshing = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = getHackNews()
            result = filterDeletedHackNews(result)
            if (result != null) {
                hackNewsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun onRefresh() {
        viewModelScope.launch {
            isRefreshing.postValue(true)
            var result = getHackNews()
            result = filterDeletedHackNews(result)
            if (result != null) {
                hackNewsModel.postValue(result)
                isRefreshing.postValue(false)
            }
        }
    }

    private fun filterDeletedHackNews(hackNewsList: List<HackNews>): List<HackNews> =
        hackNewsList.filterNot { deletedHackNewsModel.contains(it) }

    fun onDeleteHackNews(hackNews: HackNews) {
        deletedHackNewsModel.add(hackNews)
    }
}