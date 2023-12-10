package com.example.supraapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supraapp.Repository
import com.example.supraapp.registdata.local.entity.UserEntity
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: Repository): ViewModel() {
    private val getProfile = MutableLiveData<UserEntity>()
    fun observeProfile(): LiveData<UserEntity> = getProfile

    fun getDataProfile(email: String){
        viewModelScope.launch {
            when(val result = repository.getProfile(email)){
                is UserEntity -> {
                    getProfile.postValue(result)
                }
            }
        }
    }

}