package com.antoniocostadossantos.todokmp.features.home.ui.viewmodel

import com.antoniocostadossantos.todokmp.data.model.TodoModel

sealed class HomeIntent {
    object LoadTodos : HomeIntent()
    data class DeleteTodo(val tod: TodoModel) : HomeIntent()
    data class EditTodo(val todo: TodoModel) : HomeIntent()
    data class OnValueChange(val value: String) : HomeIntent()
    data object ShowBottomSheet: HomeIntent()
    data object HideBottomSheet: HomeIntent()
    data object OnSaveValue: HomeIntent()
}