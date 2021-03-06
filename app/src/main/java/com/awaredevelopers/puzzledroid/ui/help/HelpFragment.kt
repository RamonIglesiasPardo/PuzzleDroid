package com.awaredevelopers.puzzledroid.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R
import java.util.*

@Suppress("DEPRECATION")
class HelpFragment: Fragment()  {

    companion object{
        const val URL = "https://puzzledroid.github.io/PuzzleDroid/"
    }

    private lateinit var helpViewModel: HelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        helpViewModel =
            ViewModelProviders.of(this).get(HelpViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_help, container, false)
        val webview = root.findViewById<WebView>(R.id.help_webview)
        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true

        if (Locale.getDefault().getLanguage()  === "es") {
            webview.loadUrl("${URL}es")
        } else {
            webview.loadUrl(URL)
        }

        return root
    }
}