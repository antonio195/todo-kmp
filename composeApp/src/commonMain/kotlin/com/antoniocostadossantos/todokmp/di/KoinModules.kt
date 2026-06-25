package com.antoniocostadossantos.todokmp.di

import com.antoniocostadossantos.todokmp.data.database.AppDatabasedPlatform
import com.antoniocostadossantos.todokmp.data.database.databaseInstance
import com.antoniocostadossantos.todokmp.data.repository.TodoRepository
import com.antoniocostadossantos.todokmp.features.home.ui.viewmodel.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private val dataModule = module {
    single { databaseInstance() }
    single { get<AppDatabasedPlatform>().getTodoDao() }
    factoryOf(::TodoRepository)
}

private val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}

val platformModules = listOf(
    dataModule,
    viewModelModule
)