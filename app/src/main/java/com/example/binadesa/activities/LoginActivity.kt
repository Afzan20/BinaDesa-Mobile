package com.example.binadesa.activities

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.databinding.ActivityLoginBinding
import androidx.core.content.edit
import com.example.binadesa.R

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {

            val username = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            val sharedPref = getSharedPreferences(
                "user_data",
                MODE_PRIVATE
            )

            val savedUsername =
                sharedPref.getString("username", "")

            val savedPassword =
                sharedPref.getString("password", "")

            // RULE LOGIN

            if (

            // RULE 1
                username == password ||

                // RULE 2
                (
                        username == savedUsername &&
                                password == savedPassword
                        )

            ) {

                val loginPref =
                    getSharedPreferences("user_pref", MODE_PRIVATE)

                loginPref.edit()
                    .putBoolean("isLogin", true)
                    .apply()

                Toast.makeText(
                    this,
                    "Login Berhasil",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {

                binding.edtPassword.error =
                    "Username atau Password salah"

                binding.edtPassword.requestFocus()
            }
        }
    }
}