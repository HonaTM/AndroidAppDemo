package com.example.firstdemo.toDoList

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.firstdemo.todo.ToDo

@BindingAdapter("statusText")
fun TextView.setStatus(item: ToDo) {
    if(item.assignedToUser != null && item.finishedOnDate != null)
        text = "Finished"
    else if(item.assignedToUser != null)
        text = "Assigned"
    else
        text = "New"
}