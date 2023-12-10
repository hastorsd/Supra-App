package com.example.supraapp.registdata.local

import com.example.supraapp.registdata.local.entity.UserEntity

class LocalRepository(private val appDatabase: AppDatabase) {
    suspend fun insertUser(userEntity: UserEntity) {
        appDatabase.UserDao().insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return  appDatabase.UserDao().getUser(email, password)
    }

    suspend fun getProfile(email: String): UserEntity {
        return appDatabase.UserDao().getProfile(email)
    }
}