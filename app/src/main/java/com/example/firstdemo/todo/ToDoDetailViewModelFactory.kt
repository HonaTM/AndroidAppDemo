package com.example.firstdemo.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ToDoDetailViewModelFactory(private val toDo: ToDo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoDetailViewModel::class.java)) {
            return ToDoDetailViewModel(toDo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}