package com.pos.lms.mobile.util

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.Materi
import com.pos.lms.core.domain.model.MateriSchedule
import com.pos.lms.mobile.databinding.ActivityPdfViewBinding
import timber.log.Timber


/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class PdfViewActivity : AppCompatActivity() {

    private val tag = PdfViewActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val PARENT_DATA = "parent_data"
        private const val PDF_SELECTION_CODE = 99

    }

    private val parentId = "materi"
    private lateinit var binding: ActivityPdfViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = ""
        val parentIdExtra = intent.getStringExtra(PARENT_DATA)

        Timber.tag(tag).d("CHECK_DATA_TYPE : ${VideoPlayerActivity.PARENT_DATA} ")

        when (parentIdExtra) {
            parentId -> {
                val dataIntentMateri = intent.getParcelableExtra<Materi>(EXTRA_DATA)
                url = dataIntentMateri?.address.toString()
            }
            else -> {
                val dataIntentMateriSchedule = intent.getParcelableExtra<MateriSchedule>(EXTRA_DATA)
                url = dataIntentMateriSchedule?.address.toString()
            }
        }

//        if (VideoPlayerActivity.PARENT_DATA == "MATERI") {
//            val dataIntentMateri = intent.getParcelableExtra<Materi>(EXTRA_DATA)
//            url = dataIntentMateri?.address.toString()
//        } else {
//            val dataIntentMateriSchedule = intent.getParcelableExtra<MateriSchedule>(EXTRA_DATA)
//            url = dataIntentMateriSchedule?.address.toString()
//
//        }


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
//        binding.webview.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                view.loadUrl(url)
//                return true
//            }
//        }

        binding.webview.webViewClient = WebViewClient()
    }

    inner class WebViewClient : android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.progressBar3.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}