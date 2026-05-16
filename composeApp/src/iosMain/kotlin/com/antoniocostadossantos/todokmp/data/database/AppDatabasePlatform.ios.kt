package com.antoniocostadossantos.todokmp.data.database

import androidx.room.Room
import androidx.room.util.findDatabaseConstructorAndInitDatabaseImpl
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun databaseInstance(): AppDatabasedPlatform {
    val dbFilePath = "${documentDirectory()}/$dbFileName"
    return Room.databaseBuilder<AppDatabasedPlatform>(
        name = dbFilePath,
        factory = { findDatabaseConstructorAndInitDatabaseImpl(AppDatabasedPlatform::class) }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}