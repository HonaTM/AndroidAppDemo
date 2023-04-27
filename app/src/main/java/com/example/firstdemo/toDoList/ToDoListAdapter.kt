package com.example.firstdemo.toDoList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firstdemo.databinding.ToDoListDetailBinding
import com.example.firstdemo.todo.ToDo

class ToDoListAdapter(val clickListener: ToDoClickListener) : ListAdapter<ToDo, ToDoListAdapter.ViewHolder>(ToDoDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ToDoListDetailBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: ToDo, clickListener: ToDoClickListener) {
            binding.toDo = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ToDoListDetailBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class ToDoDiffCallback : DiffUtil.ItemCallback<ToDo>() {

    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem.number == newItem.number
    }


    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
        return oldItem.number == newItem.number //REDO!
    }


}

class ToDoClickListener(val clickListener: (toDo: ToDo) -> Unit) {
    fun onClick(toDo: ToDo) = clickListener(toDo)
}