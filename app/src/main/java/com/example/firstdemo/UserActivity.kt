package com.example.firstdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstdemo.databinding.ActivityMainBinding
import com.example.firstdemo.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)

        var user = User(1, "***REMOVED***", "***REMOVED***", "1234", true)

        binding.textName.text = user.firstName
        binding.textSurname.text = user.lastName

        setContentView(binding.root)
        //setContentView(R.layout.activity_user)

        binding.switchActive.setOnCheckedChangeListener{ _, isChecked ->
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