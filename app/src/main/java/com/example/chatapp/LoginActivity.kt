package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.chatapp.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.userEmail.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.userEmail.setTextColor(getColor(R.color.white))
            }
            if (!hasFocus) {
                if (isValidEmail(binding.userEmail.text.toString())) {
                    binding.userEmail.setTextColor(getColor(R.color.white))
                } else {
                    binding.userEmail.setTextColor(getColor(R.color.red))
                }
            }
        }

        binding.btnLogIn.setOnClickListener {
            if (binding.userEmail.text.isEmpty() || binding.userPassword.text.isEmpty()) {
                Toast.makeText(this, "all fields are required", Toast.LENGTH_SHORT).show()
            } else {
                if(!isValidEmail(binding.userEmail.text.toString())){
                    Toast.makeText(this, "enter valid email id", Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}