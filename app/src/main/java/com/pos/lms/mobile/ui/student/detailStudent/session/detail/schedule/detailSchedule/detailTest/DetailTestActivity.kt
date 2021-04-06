package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailTest

import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.TestJawabanPost
import com.pos.lms.core.domain.model.TestPertanyaan
import com.pos.lms.core.domain.model.TestSchedule
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailTestBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner.QuisionerActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailTestActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = QuisionerActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailTestViewModel by viewModels()
    private val binding: ActivityDetailTestBinding by viewBinding()

    // param
    private var jumlahPertanyaan: Int? = 0
    private var posisiPertanyaan: Int = 0
    private var idCount = 1
    private var beginDate = ""
    private var endDate = ""
    private var idPertanyaan = 0
    private var idJawaban = 0
    private var choicesAnswer = ""

    private lateinit var adapter: TestJawabanAdapter

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // shared preference
        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        // intent data
        val dataIntent = intent.getParcelableExtra<TestSchedule>(EXTRA_DATA)

        beginDate = CurrentDate.getToday()
        endDate = CurrentDate.getToday()


        // onclick
        binding.btnNext.setOnClickListener(this)


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Test Activity"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        // method
        setupObserver()
        buildRecycleView()
    }

    private fun setupObserver() {
        viewModel.getPertanyaan(beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
//                            adapter.setData(data.data)
                        getSinglePertanyaan()
                        jumlahPertanyaan = data.data?.size

                        Timber.tag("TestPertanyaan").d("${data.data}")
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })
    }


    private fun getSinglePertanyaan() {
        viewModel.getSinglePertanyaan(idCount.toLong()).observe(this, { data ->
            val datas = data[0]
            idPertanyaan = datas.tqsid
            setupUIPertanyaan(data)
            observerJawabawan()
        })
    }

    private fun observerJawabawan() {
        viewModel.getJawaban(idPertanyaan.toString(), beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.setData(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })
    }

    private fun observerSubmitJawaban() {

        val parId: Int = mPreferenceEntity.parId ?: 0

        val testAnswer = TestJawabanPost(
            beginDate = beginDate,
            endDate = endDate,
            question = idPertanyaan,
            textChoice = choicesAnswer,
            businessCode = "POS",
            participant = parId,
            sequenceNo = 0,
            relationQuestion = 0
        )

        viewModel.postJawaban(testAnswer).observe(this, { data ->
            when (data) {
                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    val loginMessage = getString(R.string.something_wrong)
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                }
            }


        })
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
//                idCount++
//                getSinglePertanyaan()

                if (posisiPertanyaan == jumlahPertanyaan) {
                    finish()
                    Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show()
                } else if (choicesAnswer.isNotEmpty() || choicesAnswer != "") {
                    observerSubmitJawaban()
                    idCount++
                    Timber.tag(TAG).d("COUNT_ : $idCount")
                    getSinglePertanyaan()
                    choicesAnswer = ""
                } else {
                    Toast.makeText(this, "Anda belum Memilih jawaban", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun setupUIPertanyaan(data: List<TestPertanyaan>) {
        binding.apply {
            val datas = data[0]

            val position = datas._id
            Timber.tag(TAG).d("No_Pertanyaan : $position ")
            posisiPertanyaan = idCount
            val showJumlahPertanyaan = "$posisiPertanyaan / $jumlahPertanyaan"

            tvCountQuestion.text = showJumlahPertanyaan
            tvTypeQuestion.text = "Single Choice"
            tvQuestion.text = datas.questionText
            tvQuestionDesc.text = "-"
        }

    }

    private fun buildRecycleView() {
        binding.apply {
            adapter = TestJawabanAdapter()
            rvJawaban.setHasFixedSize(true)
            rvJawaban.layoutManager = LinearLayoutManager(this@DetailTestActivity)
            rvJawaban.adapter = adapter

            adapter.onItemClick = { selectedData ->
                idJawaban = selectedData.sequenceNo
                choicesAnswer = selectedData.textChoice
                Timber.tag("Test_Choice").d(choicesAnswer)
                adapter.setChecked(selectedData.objectIdentifier)
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}