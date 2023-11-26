package com.example.supraapp.registdata.remote

import com.example.supraapp.registdata.remote.response.SurahResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/surah")
    suspend fun getSurah() : Response<SurahResponse>
}