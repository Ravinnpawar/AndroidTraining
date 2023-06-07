package com.mobileappguru.androidtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView=findViewById(R.id.webview)
        webView.webViewClient= WebViewClient()
        webView.settings.javaScriptEnabled=true

        webView.loadUrl("https://www.youtube.com/")

    }
}