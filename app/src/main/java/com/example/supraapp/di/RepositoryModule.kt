package com.example.supraapp.di

import com.example.supraapp.Repository
import com.example.supraapp.registdata.local.LocalRepository
import com.example.supraapp.registdata.remote.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module{
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { Repository(get(), get()) }
}