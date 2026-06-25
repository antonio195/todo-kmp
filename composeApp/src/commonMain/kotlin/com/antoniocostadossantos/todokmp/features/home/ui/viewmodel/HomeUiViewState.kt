package com.antoniocostadossantos.todokmp.features.home.ui.viewmodel

import com.antoniocostadossantos.todokmp.data.model.TodoModel

data class HomeUiViewState(
    val isLoading: Boolean = false,
    val showBottomSheet: Boolean = false,
    val value: String = "",
    val todos: List<TodoModel> = emptyList(),
)