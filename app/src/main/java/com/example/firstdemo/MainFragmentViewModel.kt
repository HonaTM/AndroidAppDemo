package com.example.firstdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel: ViewModel() {

    //User detail nav
    private var _navigateToUserFragment = MutableLiveData<Boolean>()
    val navigateToUserFragment : LiveData<Boolean>

    get() {
        return _navigateToUserFragment
    }

    init {
        _navigateToUserFragment.value = false
    }

    fun navigateToUserFragmentButtonClicked() {
        _navigateToUserFragment.value = true
    }

    fun navigateFinished() {
        _navigateToUserFragment.value = false
    }

    //ToDo_detail nav
    private var _navigateToToDoFragment = MutableLiveData<Boolean>()
    val navigateToToDoFragment : LiveData<Boolean>

        get() {
            return _navigateToToDoFragment
        }

    init {
        _navigateToToDoFragment.value = false
    }

    fun navigateToToDoFragmentButtonClicked() {
        _navigateToToDoFragment.value = true
    }

    fun navigateToToDoFinished() {
        _navigateToToDoFragment.value = false
    }

}