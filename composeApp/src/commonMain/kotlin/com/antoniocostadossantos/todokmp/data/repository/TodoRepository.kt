package com.antoniocostadossantos.todokmp.data.repository

import com.antoniocostadossantos.todokmp.data.database.dao.TodoDao
import com.antoniocostadossantos.todokmp.data.model.TodoModel

class TodoRepository(
    private val dao: TodoDao
) {
    fun getAllTodo() = dao.getAll()
    suspend fun newTodoModel(newTodoModel: TodoModel) = dao.insertTodo(newTodoModel)
    suspend fun deleteTodoModel(newTodoModel: TodoModel) = dao.deleteTodo(newTodoModel)
}