package com.example.supraapp.roomdatabase.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.supraapp.roomdatabase.preferences.PreferenceStorage
import kotlinx.coroutines.launch
import javax.inject.Inject

class DataStoreViewModel @Inject constructor(private val preferenceStorage: PreferenceStorage): ViewModel() {

    //saved key as liveData
    val savedKey = preferenceStorage.savedKey().asLiveData()
    fun setSavedKey(key: Boolean) {
        viewModelScope.launch {
            preferenceStorage.setSavedKey(key)
        }
    }

}