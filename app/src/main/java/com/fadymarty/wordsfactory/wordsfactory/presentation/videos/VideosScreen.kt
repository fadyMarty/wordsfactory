package com.fadymarty.wordsfactory.presentation.videos

import android.graphics.Bitmap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.*
import android.webkit.WebView
import androidx.compose.runtime.remember
import android.util.Log

@Composable
fun VideosScreen() {
    val state = rememberWebViewState("https://learnenglish.britishcouncil.org/general-english/video-zone")
    val webClient = remember {
        object : AccompanistWebViewClient() {
            override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                super.onPageStarted(view, url, favicon)
                Log.d("Accompanist WebView", "Page started loading for $url")
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        WebView(
            state = state,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
            },
            client = webClient
        )
    }
}