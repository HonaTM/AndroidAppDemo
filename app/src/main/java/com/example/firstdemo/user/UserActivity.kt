package com.example.firstdemo.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstdemo.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}