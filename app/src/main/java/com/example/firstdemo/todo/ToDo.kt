package com.example.firstdemo.todo

import android.os.Parcelable
import com.example.firstdemo.user.User
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
class ToDo(
    val number: Int,
    val title: String,
    val description: String,
    val createdByUser: User,
    val createdOnDate: LocalDate,
    val assignedToUser:	User?,
    val finishedOnDate: LocalDate?,
    val toDoTime: Long?,
    val Remark:	String?
): Parcelable {
    companion object Status {
        const val NEW = 0
        const val ASSIGNED = 1
        const val FINISHED = 2
    }
}