package com.example.practiceprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceprojekt.databinding.ActivityInfoFirstBinding

class FirstInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityInfoFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btNextFirst.setOnClickListener {
            startActivity(Intent(this, SecondInfoActivity::class.java))
        }
    }
}