package com.pos.lms.mobile.ui.materi.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.Materi
import com.pos.lms.mobile.databinding.ActivityDetailMateriBinding

class DetailMateriActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding : ActivityDetailMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataMateri  = intent.getParcelableExtra<Materi>(EXTRA_DATA)

        //onclick
        binding.btnLihatMateri.setOnClickListener {
            Toast.makeText(this,"Opppsss.... Fitur on Development",Toast.LENGTH_SHORT).show()
        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Materi"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        //function
        collectData(dataMateri)
    }

    private fun collectData(materi: Materi?) {
        if (materi != null){

            //concat string
            val title1= "${materi.companyName} - ${materi.materiTypeName}"
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