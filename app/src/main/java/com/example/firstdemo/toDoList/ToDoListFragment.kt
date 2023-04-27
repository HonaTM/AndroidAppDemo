package com.example.firstdemo.toDoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstdemo.R
import com.example.firstdemo.databinding.FragmentToDoDetailBinding
import com.example.firstdemo.databinding.FragmentToDoListBinding
import com.example.firstdemo.todo.ToDo
import com.example.firstdemo.todo.ToDoDetailFragmentArgs
import com.example.firstdemo.todo.ToDoDetailViewModel
import com.example.firstdemo.todo.ToDoDetailViewModelFactory
import com.example.firstdemo.user.User
import java.time.LocalDate

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding

    private val user = User(1, "Hona", "Test", "1234", true)
    private val user2 = User(2, "Second", "Test", "1234", true)
    private val toDo1 = ToDo(1, "First test", "Hi! This is a test", user, LocalDate.of(2023, 3, 19), user2, LocalDate.of(2023, 4, 19), 150L, "None")
    private val toDo2 = ToDo(2, "Second test", "Hi! This is a test", user, LocalDate.of(2023, 3, 19), user2, LocalDate.of(2023, 4, 19), 150L, "None")
    private val toDo3 = ToDo(3, "Third test", "Hi! This is a test", user, LocalDate.of(2023, 3, 19), user2, null, 150L, "None")


    private val viewModelFactory: ToDoListViewModelFactory by lazy {
        ToDoListViewModelFactory(listOf(toDo1, toDo2, toDo3))
    }
    private val viewModel: ToDoListViewModel by viewModels{ viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_to_do_list, container, false)
        binding.viewModel = viewModel

        val adapter = ToDoListAdapter(ToDoClickListener {
            viewModel.navigateToToDoDetailFragmentButtonClicked(it)
        })
        binding.toDoList.adapter = adapter

        viewModel.toDo.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = viewLifecycleOwner
        binding.toDoList.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false) //TODO context -> requireActivity?

        viewModel.navigateToToDoDetailFragment.observe(viewLifecycleOwner, Observer {toDo ->
            toDo?.let {
                this.findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment(it))
                viewModel.navigateToToDoDetailFinished()
            }
        })

        return binding.root
    }

}