package com.example.todolist

data class AppViewState(
    val tasks: List<Task>,
)

data class Task(
    val title: String,
    val isChecked:Boolean,
    val idTask:Int,
)