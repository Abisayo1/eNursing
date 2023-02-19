package com.abisayo.computerize1

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.annotation.RequiresApi
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityAlgorithmExampleBinding
import com.abisayo.computerize1.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    var URL= "https://www.google.com"
    var topic = ""

    private lateinit var webView:WebView
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        topic = intent.getStringExtra(Constants.TOPIC).toString()

        if (topic == "Algorithms") {
            URL = "https://www.geeksforgeeks.org/introduction-to-algorithms/"
        } else if (topic == "Flowcharts") {
            URL = "https://www.geeksforgeeks.org/an-introduction-to-flowcharts/"
        }

        webView = binding.web

        webView.apply {
            loadUrl(URL)
            webViewClient = webViewClient
            settings.javaScriptEnabled = true

        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}