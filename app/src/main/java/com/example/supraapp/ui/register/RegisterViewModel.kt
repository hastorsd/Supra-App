package com.example.supraapp.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supraapp.Repository
import com.example.supraapp.registdata.local.AppDatabase
import com.example.supraapp.registdata.local.entity.UserEntity
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: Repository): ViewModel() {
    private val isRegister = MutableLiveData<Boolean>()
    fun observeIsRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: UserEntity) {
        viewModelScope.launch {
            try {
                repository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}