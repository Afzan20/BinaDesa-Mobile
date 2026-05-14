package com.example.binadesa.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.databinding.ActivityLoginBinding
import androidx.core.content.edit

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (email == "admin@gmail.com" && password == "12345") {

                val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

                sharedPref.edit {
                    putBoolean("isLogin", true)
                }

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {
                Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}