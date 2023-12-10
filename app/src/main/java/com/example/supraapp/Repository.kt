package com.example.supraapp

import com.example.supraapp.registdata.local.AppDatabase
import com.example.supraapp.registdata.local.LocalRepository
import com.example.supraapp.registdata.local.entity.UserEntity
import com.example.supraapp.registdata.remote.RemoteRepository

class Repository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(userEntity: UserEntity) {
        localRepository.insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return localRepository.getUser(email, password)
    }

    suspend fun getProfile(email: String): UserEntity {
        return localRepository.getProfile(email)
    }

    suspend fun getSurah() = remoteRepository.getSurah()
}