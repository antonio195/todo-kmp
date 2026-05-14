package com.antoniocostadossantos.todokmp.di

import org.koin.dsl.module

actual val platformModule = module {
    // Or use Compiler Plugin DSL / Annotations if no custom logic needed
//    single<IosPlatformHelper>() bind PlatformHelper::class
//    single<IosDatabaseDriver>() bind DatabaseDriver::class
}