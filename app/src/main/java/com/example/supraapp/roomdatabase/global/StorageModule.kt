package com.example.supraapp.roomdatabase.global

import com.example.supraapp.roomdatabase.preferences.PreferenceImpl
import com.example.supraapp.roomdatabase.preferences.PreferenceStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindsPreferenceStorage(preferenceStorageImpl: PreferenceImpl): PreferenceStorage

}