package com.example.practiceprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceprojekt.databinding.ActivityThirdInfoBinding

class ThirdInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btBackThird.setOnClickListener {
            startActivity(Intent(this, SecondInfoActivity::class.java))
        }
    }
}