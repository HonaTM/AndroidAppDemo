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

    //ToDo_list nav
    private var _navigateToToDoListFragment = MutableLiveData<Boolean>()
    val navigateToToDoListFragment : LiveData<Boolean>

        get() {
            return _navigateToToDoListFragment
        }

    init {
        _navigateToToDoListFragment.value = false
    }

    fun navigateToToDoListFragmentButtonClicked() {
        _navigateToToDoListFragment.value = true
    }

    fun navigateToToDoListFinished() {
        _navigateToToDoListFragment.value = false
    }

}