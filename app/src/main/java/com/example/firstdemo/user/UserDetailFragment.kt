package com.example.firstdemo.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstdemo.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {

    private lateinit var binding : FragmentUserDetailBinding
    private var user = User(1, "***REMOVED***", "***REMOVED***", "1234", true)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)

        binding.textName.text = user.firstName
        binding.textSurname.text = user.lastName

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.switchActive.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.switchActive.text = "Active"
                user.isActive = true
            } else {
                binding.switchActive.text = "Inactive"
                user.isActive = false
            }
        }
    }

}