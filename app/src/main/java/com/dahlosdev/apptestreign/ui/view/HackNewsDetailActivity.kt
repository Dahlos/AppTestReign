package com.dahlosdev.apptestreign.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.dahlosdev.apptestreign.databinding.ActivityHackNewsDetailBinding

class HackNewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHackNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHackNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.webChromeClient = object : WebChromeClient() {}

        binding.webView.webViewClient = object : WebViewClient() {}

        val settings = binding.webView.settings
        settings.javaScriptEnabled = true

        binding.webView.loadUrl("https://google.com")
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}