package com.example.firstdemo.toDoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstdemo.todo.ToDo
import com.example.firstdemo.todo.ToDoDetailViewModel

class ToDoListViewModelFactory(private val toDo: List<ToDo>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoListViewModel::class.java)) {
            return ToDoListViewModel(toDo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}