package com.example.firstdemo.todo

import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.format.DateTimeFormatter

class ToDoDetailViewModel(__toDo: ToDo): ViewModel() {

    private var _toDo = MutableLiveData<ToDo>()
    val toDo : LiveData<ToDo>
        get() {
            return _toDo
        }
    init {
        _toDo.value = __toDo
    }

    val toDoStatus : String
        get() {
            if(_toDo.value!!.assignedToUser != null && _toDo.value!!.finishedOnDate != null)
                return "Finished"
            if(_toDo.value!!.assignedToUser != null)
                return "Assigned"
            return "New"
        }

    val createdDateString : String
        get() {
            var df = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return _toDo.value!!.createdOnDate.format(df)
        }

    val completedDateString : String
        get() {
            var result = "NaN"
            if(_toDo.value!!.finishedOnDate != null){
                var df = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                result = _toDo.value!!.finishedOnDate!!.format(df)
            }
            return result
        }

    val toDoTimeString: String
        get() {
            var result = "00:00"
            if(_toDo.value!!.toDoTime != null){
                result = DateUtils.formatElapsedTime(_toDo.value!!.toDoTime!!)
            }
            return result
        }

}