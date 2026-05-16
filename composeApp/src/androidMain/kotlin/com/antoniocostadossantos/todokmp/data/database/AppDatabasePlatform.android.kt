package com.antoniocostadossantos.todokmp.data.database

import androidx.room.Room
import org.koin.mp.KoinPlatform

actual fun databaseInstance(): AppDatabasedPlatform {
    return Room.databaseBuilder(
        KoinPlatform.getKoin().get(),
        AppDatabasedPlatform::class.java,
        dbFileName
    ).build()
}