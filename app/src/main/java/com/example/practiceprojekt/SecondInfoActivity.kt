package com.example.practiceprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceprojekt.databinding.ActivityInfoFirstBinding
import com.example.practiceprojekt.databinding.ActivityInfoSecondBinding

class SecondInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityInfoSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btBackSecond.setOnClickListener {
            startActivity(Intent(this, FirstInfoActivity::class.java))
        }

        binding.btNextSecond.setOnClickListener {
            startActivity(Intent(this, ThirdInfoActivity::class.java))
        }
    }
}