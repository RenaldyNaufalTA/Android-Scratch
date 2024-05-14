package com.vavoryn.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vavoryn.myapp.databinding.ActivityLayoutBinding

class LayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}