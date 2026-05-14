package com.example.binadesa.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.R
import com.example.binadesa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.selectedItemId = R.id.nav_home

        setSupportActionBar(binding.toolbar)

        binding.cardProfil.setOnClickListener {
            startActivity(Intent(this, ProfileDesaActivity::class.java))
        }

        binding.cardKegiatan.setOnClickListener {
            startActivity(Intent(this, KegiatanActivity::class.java))
        }

        binding.cardUmkm.setOnClickListener {
            startActivity(Intent(this, UmkmActivity::class.java))
        }

        binding.cardWeb.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

            sharedPref.edit()
                .clear()
                .apply()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

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
    }
}