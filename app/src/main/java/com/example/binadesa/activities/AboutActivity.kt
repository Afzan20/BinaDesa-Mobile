package com.example.binadesa.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.R
import com.example.binadesa.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.selectedItemId = R.id.nav_about

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_kegiatan -> {
                    startActivity(Intent(this, KegiatanActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_umkm -> {
                    startActivity(Intent(this, UmkmActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_about -> {
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}