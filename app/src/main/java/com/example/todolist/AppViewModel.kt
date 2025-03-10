package com.example.todolist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {
    //-> viewState -> list -> task
    private val _tasks = MutableStateFlow(AppViewState(emptyList()))
    val tasks = _tasks.asStateFlow()

    fun addTask(title: String) {
        val newTask = Task(
            title = title,
            isChecked = false,
            idTask = _tasks.value.tasks.size + 1,
        )

        _tasks.update {
            it.copy(tasks = it.tasks + newTask)
        }
    }

    fun isChecked(idTask: Int) {
        _tasks.update {
            it.copy(
                tasks = it.tasks.map {
                    if (it.idTask == idTask) it.copy(isChecked = !it.isChecked)
                    else it
                })
        }
    }


    fun removeTask(idTask: Int) {
        _tasks.update {
            it.copy(
                tasks = it.tasks.filter {
                    it.idTask != idTask
                }
            )
        }
    }
}
