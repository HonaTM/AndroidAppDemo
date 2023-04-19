package com.example.firstdemo.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    var firstName: String,
    var lastName: String,
    var password: String,
    var isActive: Boolean
): Parcelable {

}