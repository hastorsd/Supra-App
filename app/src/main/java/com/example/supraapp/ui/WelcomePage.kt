package com.example.supraapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.supraapp.R
import com.example.supraapp.databinding.ActivityWelcomePageBinding

class WelcomePage : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToHome.setOnClickListener {
            startActivity(Intent(this, TampilanApi::class.java))
            finish()
        }
    }
}