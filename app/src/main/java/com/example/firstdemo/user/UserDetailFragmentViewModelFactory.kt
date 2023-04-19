package com.example.firstdemo.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserDetailFragmentViewModelFactory(private val user: User,
                                         private val userActive: String,
                                         private val userNotActive: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailFragmentViewModel::class.java)) {
            return UserDetailFragmentViewModel(user, userActive, userNotActive) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
