package com.antoniocostadossantos.todokmp.features.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antoniocostadossantos.todokmp.data.model.TodoModel
import com.antoniocostadossantos.todokmp.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _homeViewState = MutableStateFlow(HomeUiViewState())
    val homeViewState: StateFlow<HomeUiViewState> = _homeViewState

    init {
        handleIntent(HomeIntent.LoadTodos)
    }

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.DeleteTodo -> TODO()
            is HomeIntent.EditTodo -> TODO()
            HomeIntent.LoadTodos -> loadTodos()
            HomeIntent.ShowBottomSheet -> showBottomSheet()
            HomeIntent.HideBottomSheet -> hideBottomSheet()
            is HomeIntent.OnValueChange -> onValueChange(intent.value)
            HomeIntent.OnSaveValue -> onSaveValue()
        }
    }

    private fun onSaveValue() {
        viewModelScope.launch {
            _homeViewState.update {
                val value = it.value
                todoRepository.newTodoModel(
                    TodoModel(
                        title = value
                    )
                )
                _homeViewState.value.copy(value = "")
            }
            hideBottomSheet()
        }
    }

    private fun onValueChange(value: String) {
        viewModelScope.launch {
            _homeViewState.update {
                _homeViewState.value.copy(value = value)
            }
        }
    }

    private fun showBottomSheet() {
        viewModelScope.launch {
            _homeViewState.update {
                _homeViewState.value.copy(showBottomSheet = true)
            }
        }
    }

    private fun hideBottomSheet() {
        viewModelScope.launch {
            _homeViewState.update {
                _homeViewState.value.copy(showBottomSheet = false)
            }
        }
    }


    private fun loadTodos() {
        _homeViewState.update {
            _homeViewState.value.copy(isLoading = true)
        }
        viewModelScope.launch {
            todoRepository.getAllTodo().collect { todos ->
                _homeViewState.update {
                    _homeViewState.value.copy(
                        isLoading = false,
                        todos = todos,
                    )
                }
            }
        }
    }
}