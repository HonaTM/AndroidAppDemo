package com.example.firstdemo.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.firstdemo.R
import com.example.firstdemo.databinding.FragmentToDoDetailBinding
import com.example.firstdemo.user.User
import java.time.LocalDate

class ToDoDetailFragment : Fragment() {

    private lateinit var binding: FragmentToDoDetailBinding
    private val args: ToDoDetailFragmentArgs by navArgs()

    private val viewModelFactory: ToDoDetailViewModelFactory by lazy {
        ToDoDetailViewModelFactory(args.toDo)
    }
    private val viewModel: ToDoDetailViewModel by viewModels{ viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_to_do_detail, container, false)
        binding.viewModel = viewModel

        return binding.root
    }

}