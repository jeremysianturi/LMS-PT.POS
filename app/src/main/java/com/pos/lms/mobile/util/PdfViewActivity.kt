package com.pos.lms.mobile.util

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.mobile.databinding.ActivityPdfViewBinding


class PdfViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdfViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val url = "https://pos-lms.digitalevent.id/lms/api/materistream?materi_id=7"
        val openUurl = "https://docs.google.com/viewer?embedded = true&url = $url"

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