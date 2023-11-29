package com.example.supraapp.registdata.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.supraapp.registdata.local.dao.UserDao
import com.example.supraapp.registdata.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao

}