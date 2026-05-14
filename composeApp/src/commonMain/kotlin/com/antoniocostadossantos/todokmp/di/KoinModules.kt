package com.antoniocostadossantos.todokmp.di

import org.koin.core.module.Module
import org.koin.dsl.module

// Shared definitions (Compiler Plugin DSL)
val sharedModule = module {
//    single<UserRepository>()
//    single<ApiClient>()
//    factory<GetUserUseCase>()
}

// Platform-specific modules (defined per platform)
expect val platformModule: Module