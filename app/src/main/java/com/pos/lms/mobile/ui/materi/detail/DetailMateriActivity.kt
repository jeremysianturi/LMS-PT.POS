package com.pos.lms.mobile.ui.materi.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.Materi
import com.pos.lms.mobile.databinding.ActivityDetailMateriBinding
import com.pos.lms.mobile.util.PdfViewActivity
import com.pos.lms.mobile.util.VideoPlayerActivity
import timber.log.Timber

class DetailMateriActivity : AppCompatActivity() {

    private val tag = DetailMateriActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val PARENT_DATA = "materi"

    }

    private lateinit var binding: ActivityDetailMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataMateri = intent.getParcelableExtra<Materi>(EXTRA_DATA)
        val fileType = dataMateri?.fileType

        Timber.tag(tag).d("FileType : $fileType")
        //onclick
        binding.btnLihatMateri.setOnClickListener {
            if (fileType == "VIDEO") {
                val mIntent = Intent(this, VideoPlayerActivity::class.java)
                mIntent.putExtra(VideoPlayerActivity.EXTRA_DATA, dataMateri)
                mIntent.putExtra(VideoPlayerActivity.PARENT_DATA, PARENT_DATA)
                startActivity(mIntent)
            } else {
                val mIntent = Intent(this, PdfViewActivity::class.java)
                mIntent.putExtra(PdfViewActivity.EXTRA_DATA, dataMateri)
                mIntent.putExtra(PdfViewActivity.PARENT_DATA, PARENT_DATA)
                startActivity(mIntent)
            }


        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Materi"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        //function
        collectData(dataMateri)
    }

    private fun collectData(materi: Materi?) {
        if (materi != null) {

            //concat string
            val title1 = "${materi.companyName} - ${materi.materiTypeName}"
            val date = "${materi.beginDate} - ${materi.endDate}"

            binding.tvTitleDetaillMateri.text = title1
            binding.tvTitleDetailMateri2.text = materi.materiName
            binding.tvtitleDetailMateri3.text = materi.competenceName

            // content
            binding.content.tvContentAgency.text = materi.companyName
            binding.content.tvContenTitle.text = materi.materiName
            binding.content.tvContentDescription.text = materi.description
            binding.content.tvContentMateriType.text = materi.materiTypeName
            binding.content.tvContentMethod.text = materi.methodName
            binding.content.tvContentAddress.text = materi.address
            binding.content.tvContentCompetency.text = materi.competenceName
            binding.content.tvContentProficencyLevel.text = materi.plCodeName
            binding.content.tvContentSelling.text = materi.sellingPrice
            binding.content.tvContentPurchase.text = materi.purchasePrice
            binding.content.tvContentDate.text = date


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}