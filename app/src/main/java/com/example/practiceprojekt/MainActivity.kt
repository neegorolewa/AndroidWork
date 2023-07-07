package com.example.practiceprojekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import com.example.practiceprojekt.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val inputTypeShow = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
    private val inputTypeHide = InputType.TYPE_TEXT_VARIATION_PASSWORD

    private var checkHideShow: Boolean = true
    private var checkHideShowRetype: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MainDb.getDb(this)

        binding.btSignUp.setOnClickListener {
            if (binding.edName.text.toString().isNotEmpty() && binding.edPhone.text.toString().isNotEmpty() && binding.edPassword.text.toString().isNotEmpty() && binding.edRetypePassword.text.toString().isNotEmpty()) {
                if(binding.edPassword.text.toString() == binding.edRetypePassword.text.toString()) {

                    val item = Item(null,
                        binding.edName.text.toString(),
                        binding.edPhone.text.toString(),
                        binding.edPassword.text.toString()
                    )
                    Thread {
                        db.getDao().insertClient(item)
                    }.start()

                    startActivity(Intent(this, FirstInfoActivity::class.java))

                } else {
                    binding.edPassword.text = null
                    binding.edRetypePassword.text = null
                    binding.edPassword.setHintTextColor(resources.getColor(R.color.red))
                    binding.edRetypePassword.setHintTextColor(resources.getColor(R.color.red))
                }
            } else {
                if (binding.edName.text.toString().isEmpty()) {
                    binding.edName.setHintTextColor(resources.getColor(R.color.red))
                }
                if (binding.edPhone.text.toString().isEmpty()) {
                    binding.edPhone.setHintTextColor(resources.getColor(R.color.red))
                }
                if (binding.edPassword.text.toString().isEmpty()) {
                    binding.edPassword.setHintTextColor(resources.getColor(R.color.red))
                }
                if (binding.edRetypePassword.text.toString().isEmpty()) {
                    binding.edRetypePassword.setHintTextColor(resources.getColor(R.color.red))
                }
            }
        }
    }

    fun onClickShowHide(view: View) {
        if(checkHideShow) {
            checkHideShow = false
            binding.imgHideShow.setImageResource(R.drawable.hide)
            binding.edPassword.inputType = inputTypeShow
        }else {
            checkHideShow = true
            binding.imgHideShow.setImageResource(R.drawable.show)
            binding.edPassword.inputType = inputTypeHide
        }
    }

    fun onClickShowHideRetype(view: View) {
        if(checkHideShowRetype) {
            checkHideShowRetype = false
            binding.imgHideShowRetype.setImageResource(R.drawable.hide)
            binding.edRetypePassword.inputType = inputTypeShow
        } else {
            checkHideShowRetype = true
            binding.imgHideShowRetype.setImageResource(R.drawable.show)
            binding.edRetypePassword.inputType = inputTypeHide
        }
    }

}