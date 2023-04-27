package com.example.firstdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.firstdemo.databinding.FragmentMainBinding
import com.example.firstdemo.todo.ToDo
import com.example.firstdemo.user.User
import com.example.firstdemo.user.UserActivity
import java.time.LocalDate

class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    private val viewModel: MainFragmentViewModel by viewModels()
    private val user = User(1, "***REMOVED***", "***REMOVED***", "1234", true)

    private val user2 = User(2, "***REMOVED***", "***REMOVED***", "1234", true)
    private val toDo = ToDo(1, "First test", "Hi! This is test", user, LocalDate.of(2023, 3, 19), user2, LocalDate.of(2023, 4, 19), 150L, "None")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigateToUserFragment.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToUserActivity(user))
                viewModel.navigateFinished()
            }
        })

        viewModel.navigateToToDoFragment.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToToDoDetailFragment(toDo))
                viewModel.navigateToToDoFinished()
            }
        })

        viewModel.navigateToToDoListFragment.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToToDoListFragment())
                viewModel.navigateToToDoListFinished()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}