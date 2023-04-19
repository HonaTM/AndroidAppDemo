package com.example.firstdemo.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserDetailFragmentViewModel(__user: User, __userActive: String, __userNotActive: String): ViewModel() {

    private var _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() {
            return _user
        }
    init {
        _user.value = __user
    }

    private var _userActive = __userActive
    private var _userNotActive = __userNotActive

    private var _userActiveText = MutableLiveData<String>()
    val userActiveText : LiveData<String>
        get() {
            return _userActiveText
        }
    init {
        _userActiveText.value = _userActive
    }

    fun onActiveChanged(){
        if (_user.value?.isActive == true) {
            _userActiveText.value = _userActive
        } else {
            _userActiveText.value = _userNotActive
        }
        //Not necessary?
        _user.value?.isActive = _user.value?.isActive == true
    }

}