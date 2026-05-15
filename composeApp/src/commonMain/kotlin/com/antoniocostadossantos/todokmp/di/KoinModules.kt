package com.antoniocostadossantos.todokmp.di

import org.koin.dsl.module

private val dataModule = module {

}

private val viewModelModule = module {

}

val platformModules = listOf(
    dataModule,
    viewModelModule
)