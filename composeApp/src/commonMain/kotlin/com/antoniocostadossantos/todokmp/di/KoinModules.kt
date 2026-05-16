package com.antoniocostadossantos.todokmp.di

import com.antoniocostadossantos.todokmp.data.database.AppDatabasedPlatform
import com.antoniocostadossantos.todokmp.data.database.databaseInstance
import org.koin.dsl.module

private val dataModule = module {
    single { databaseInstance() }
    single { get<AppDatabasedPlatform>().getTodoDao() }
}

private val viewModelModule = module {

}

val platformModules = listOf(
    dataModule,
    viewModelModule
)