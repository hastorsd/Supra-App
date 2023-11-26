package com.example.supraapp.registdata.remote

class RemoteRepository(private val apiService: ApiService) {
    suspend fun getSurah() = apiService.getSurah()
}