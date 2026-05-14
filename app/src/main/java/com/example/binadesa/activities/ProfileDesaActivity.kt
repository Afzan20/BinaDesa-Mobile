package com.example.binadesa.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.databinding.ActivityProfileDesaBinding

class ProfileDesaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}