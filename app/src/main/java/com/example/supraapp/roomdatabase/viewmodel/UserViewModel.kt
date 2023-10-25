package com.example.supraapp.roomdatabase.viewmodel


import androidx.lifecycle.*
import com.example.supraapp.roomdatabase.model.User
import com.example.supraapp.roomdatabase.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel() {


    /**
     * Insert user details
     */
    private val _response = MutableLiveData<Long>()
    val response: LiveData<Long> = _response

    //insert user details to room database
    fun insertUserDetails(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(userRepo.createUserRecords(user))
        }
    }

    /**
     * Retrieve user details
     */
    //check if song is liked
    private val _userDetails = MutableStateFlow<List<User>>(emptyList())
    val userDetails : StateFlow<List<User>> =  _userDetails

    fun doGetUserDetails(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.getUserDetails
                .catch { e->
                    //Log error here
                }
                .collect {
                    _userDetails.value = it
                }
        }
    }

    /**
     * Delete single user record
     */
    fun doDeleteSingleUserRecord(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.deleteSingleUserRecord()
        }
    }

}