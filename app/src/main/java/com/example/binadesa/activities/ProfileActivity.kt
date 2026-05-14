package com.example.binadesa.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.R
import com.example.binadesa.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.selectedItemId = R.id.nav_profile

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> {

                    if (binding.bottomNavigation.selectedItemId != R.id.nav_home) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }

                    true
                }

                R.id.nav_kegiatan -> {

                    if (binding.bottomNavigation.selectedItemId != R.id.nav_kegiatan) {
                        startActivity(Intent(this, KegiatanActivity::class.java))
                        finish()
                    }

                    true
                }

                R.id.nav_umkm -> {

                    if (binding.bottomNavigation.selectedItemId != R.id.nav_umkm) {
                        startActivity(Intent(this, UmkmActivity::class.java))
                        finish()
                    }

                    true
                }

                R.id.nav_about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_profile -> {

                    if (binding.bottomNavigation.selectedItemId != R.id.nav_profile) {
                        startActivity(Intent(this, ProfileActivity::class.java))
                        finish()
                    }

                    true
                }

                else -> false
            }
        }

        binding.btnLogout.setOnClickListener {

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

            sharedPref.edit()
                .clear()
                .apply()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}