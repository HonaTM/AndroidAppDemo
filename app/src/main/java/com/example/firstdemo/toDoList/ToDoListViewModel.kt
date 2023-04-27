package com.example.firstdemo.toDoList

import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstdemo.todo.ToDo
import java.time.format.DateTimeFormatter

class ToDoListViewModel(__toDo: List<ToDo>): ViewModel() {

    private var _toDo = MutableLiveData<List<ToDo>>()
    val toDo : LiveData<List<ToDo>>
        get() {
            return _toDo
        }
    init {
        _toDo.value = __toDo
    }

    //ToDo_detail nav
    private var _navigateToToDoDetailFragment = MutableLiveData<ToDo?>()
    val navigateToToDoDetailFragment : LiveData<ToDo?>

    get() {
        return _navigateToToDoDetailFragment
    }

    init {
        _navigateToToDoDetailFragment.value = null
    }

    fun navigateToToDoDetailFragmentButtonClicked(toDo: ToDo) {
        _navigateToToDoDetailFragment.value = toDo
    }

    fun navigateToToDoDetailFinished() {
        _navigateToToDoDetailFragment.value = null
    }

    /*val toDoStatus : String
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
        }*/

}