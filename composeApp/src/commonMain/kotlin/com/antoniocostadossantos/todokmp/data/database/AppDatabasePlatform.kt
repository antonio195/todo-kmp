package com.antoniocostadossantos.todokmp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.antoniocostadossantos.todokmp.data.database.dao.TodoDao
import com.antoniocostadossantos.todokmp.data.model.TodoModel

@Database(entities = [TodoModel::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabasedPlatform : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabasedPlatform> {
    override fun initialize(): AppDatabasedPlatform
}

expect fun databaseInstance(): AppDatabasedPlatform

internal const val dbFileName = "app-database.db"