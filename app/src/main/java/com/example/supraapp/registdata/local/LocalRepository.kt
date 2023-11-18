package com.example.supraapp.registdata.local

import com.example.supraapp.registdata.local.entity.UserEntity
import com.mobsandgeeks.saripaar.annotation.Password

class LocalRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(userEntity: UserEntity) {
        appDatabase.UserDao().insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return  appDatabase.UserDao().getUser(email, password)
    }
}