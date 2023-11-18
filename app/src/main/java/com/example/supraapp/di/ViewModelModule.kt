package com.example.supraapp.di

import com.example.supraapp.ui.login.LoginViewModel
import com.example.supraapp.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module{
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
}