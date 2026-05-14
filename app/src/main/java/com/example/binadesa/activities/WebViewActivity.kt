package com.example.binadesa.activities

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.binadesa.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true

        binding.webView.loadUrl("https://abhinayy.alwaysdata.net/")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}