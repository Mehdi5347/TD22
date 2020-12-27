package com.example.td2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.td2.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
    ),
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DatabaseDao(): DatabaseDao
}