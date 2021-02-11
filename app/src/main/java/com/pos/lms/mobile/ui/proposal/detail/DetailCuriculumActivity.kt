package com.pos.lms.mobile.ui.proposal.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.domain.model.Curiculum
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailCuriculumBinding
import com.pos.lms.mobile.ui.proposal.update.UpdateCuriculumActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCuriculumActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailCuriculumBinding

    private var dataCuriculum: Curiculum? = null

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCuriculumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataCuriculum = intent.getParcelableExtra(EXTRA_DATA)

        // onclick
        binding.btnUpdate.setOnClickListener(this)
        binding.btnDelete.setOnClickListener(this)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Curiculum"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        setupData(dataCuriculum)
    }

    private fun setupData(data: Curiculum?) {
        with(binding) {
            tvContentEvent.text = data?.requestName ?: "-"
            tvContentCompany.text = data?.companyName ?: "-"
            tvContentType.text = data?.requestTypeName ?: "-"
            tvContentPLevel.text = data?.plName ?: "-"
            tvContentDescription.text = data?.requestDescription ?: "-"
            tvContentBegindate.text = data?.beginDate ?: "-"
            tvContentEndDate.text = data?.endDate ?: "-"

            // header
            textView14.text = data?.companyName ?: ""
            textView16.text = data?.requestTypeName ?: ""
            textView15.text = data?.requestName ?: ""
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnUpdate -> {
                val mIntent = Intent(this, UpdateCuriculumActivity::class.java)
                mIntent.putExtra(UpdateCuriculumActivity.EXTRA_DATA, dataCuriculum)
                startActivity(mIntent)
            }
            R.id.btnDelete -> {
//                submitDelete()
            }
        }
    }

}