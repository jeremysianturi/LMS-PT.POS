package com.pos.lms.mobile.util

import android.os.Bundle
import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.MateriSchedule
import com.pos.lms.mobile.databinding.ActivityPdfViewBinding


class PdfViewActivity : AppCompatActivity() {


    companion object {
        const val EXTRA_DATA = "extra_data"
        private const val PDF_SELECTION_CODE = 99

    }

    private lateinit var binding: ActivityPdfViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent.getParcelableExtra<MateriSchedule>(EXTRA_DATA)

        val url = dataIntent?.address

        binding.apply {
            webview.settings.javaScriptEnabled = true
            webview.settings.pluginState = PluginState.ON
            webview.settings.setSupportZoom(true)
        }
        val openUurl = "http://docs.google.com/gview?embedded=true&url=$url"

        showPdf(openUurl)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "View PDF"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun showPdf(openUurl: String) {

        binding.webview.loadUrl(openUurl)
        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}