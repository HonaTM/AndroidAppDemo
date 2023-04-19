package com.example.firstdemo.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.firstdemo.R
import com.example.firstdemo.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {

    private lateinit var binding : FragmentUserDetailBinding

    private val viewModelFactory: UserDetailFragmentViewModelFactory by lazy {
        UserDetailFragmentViewModelFactory((activity as UserActivity).getUser(),
                                            resources.getString(R.string.userActive),
                                            resources.getString(R.string.userNotActive))
    }
    private val viewModel: UserDetailFragmentViewModel by viewModels{ viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_user_detail, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}