package com.example.td2.injection

import android.content.Context
import androidx.room.Room
import com.example.td2.data.local.AppDatabase
import com.example.td2.data.local.DatabaseDao
import com.example.td2.data.repository.UserRepository
import com.example.td2.domain.usecase.CreateUserUseCase
import com.example.td2.domain.usecase.GetUserUseCase
import com.example.td2.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule:Module = module {

    factory{ MainViewModel(get(), get()) }

    }

val domainModule :Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule :Module = module {
    single{ UserRepository(get())}
    single{createDatabase(androidContext())}
}

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.DatabaseDao()
}

