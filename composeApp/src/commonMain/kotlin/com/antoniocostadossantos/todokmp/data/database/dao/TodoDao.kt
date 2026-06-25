package com.antoniocostadossantos.todokmp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.antoniocostadossantos.todokmp.data.model.TodoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todomodel")
    fun getAll(): Flow<List<TodoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoModel): Long

    @Update
    suspend fun updateTodo(todo: TodoModel)

    @Delete
    suspend fun deleteTodo(todo: TodoModel)
}