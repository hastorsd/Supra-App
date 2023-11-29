package com.example.supraapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supraapp.Repository
import com.example.supraapp.registdata.remote.response.NewSurahResponse
import com.example.supraapp.registdata.remote.response.SurahResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {
    private val getSurah = MutableLiveData<Response<NewSurahResponse>>()
    val observeSurah: LiveData<Response<NewSurahResponse>> = getSurah

    fun getSurah(){
        viewModelScope.launch {
            try {
                val result = repository.getSurah()
                getSurah.postValue(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}