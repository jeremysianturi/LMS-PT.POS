package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.QuisionerAnswerPost
import com.pos.lms.core.domain.model.QuisionerAnswer
import com.pos.lms.core.domain.model.QuisionerPertanyaan
import com.pos.lms.core.domain.model.QuisionerSchedule
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityQuisionerBinding
import com.pos.lms.mobile.helper.CurrentDate
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class QuisionerActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = QuisionerActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityQuisionerBinding
    private lateinit var adapter: AnswerAdapter

    private val viewModel: QuisionerViewModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var quisionerId: String? = "0"
    private var posisiPertanyaan: Int = 0
    private var idCount = 1
    private var jumlahPertanyaan: Int? = 0
    private var choicesAnswer = ""
    private var objects = ""
    private var relationQuisionerId = ""
    private var beginDate = ""
    private var endDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuisionerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        beginDate = CurrentDate.getToday()
        endDate = CurrentDate.getToday()

        val dataIntent = intent.getParcelableExtra<QuisionerSchedule>(EXTRA_DATA)

        objects = dataIntent?.templateCodeId ?: ""
        relationQuisionerId = dataIntent?.relationQuesionerId ?: "0"

        // method
        buildRecycleView()
        setupObserver(beginDate, endDate)
        validateData()

        // onclick
        binding.btnNext.setOnClickListener(this)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Quisioner Activity"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupObserver(beginDate: String, endDate: String) {

//        val objects = "FORM"
        val tableCode = "QUESN"
        val relation = "Q001"
        val otype = "TPLCD"


        // get quisioner checked
        viewModel.getCheckedAnswer().observe(this, { data ->
            adapter.setData(data)
            Timber.tag("ANSWER_DATA").d("$data")
        })

        // get quisioner from api
        viewModel.getQuisionerPertanyaan(objects, tableCode, relation, otype, beginDate, endDate)
            .observe(this, { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
//                            adapter.setData(data.data)
                            getSinglePertanyaan()
                            jumlahPertanyaan = data.data?.size

                            Timber.tag("QuiseionerPertanyaan").d("${data.data}")
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
        // get single data from local source
        viewModel.getQuisionerPertanyaanWithId(idCount.toLong()).observe(this, { data ->
            setupdataPertanyaan(data)
            quisionerId = data[0].quesionerId
            observerAnswer(quisionerId!!)
            Timber.tag(TAG).d("QuisionerId : $quisionerId")
        })
    }

    private fun observerAnswer(quisionerIds: String) {

        val beginDate = CurrentDate.getToday()
        val endDate = CurrentDate.getToday()

        // get quisioner from remote
        viewModel.getQuisionerAnswer(quisionerIds, beginDate, endDate)
            .observe(this, { data ->
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

    private fun setupCheckedAnswerOserver(selectedData: QuisionerAnswer, state: Boolean) {
        viewModel.setCheckedQuisionerUpdate(selectedData, state)
    }

    private fun setupdataPertanyaan(data: List<QuisionerPertanyaan>) {
        binding.apply {

            val datas = data[0]
//            val countQuestions =
//                "Question : ${data[counter].no} / ${data[this@QuisionerActivity.count].total}"

            val position = datas._id
            posisiPertanyaan = position.toInt()
            val showJumlahPertanyaan = "$position / $jumlahPertanyaan"

            tvCountQuestion.text = showJumlahPertanyaan
            tvTypeQuestion.text = datas.questionerTypeName
            tvQuestion.text = datas.quesionerTitle
            tvQuestionDesc.text = datas.quesionerText
        }

    }

    private fun validateData() {
        viewModel.getOnlyCheckedAnswer().observe(this, { data ->
            if (data.isEmpty()) {
                choicesAnswer = ""
            } else {
                // join String
                choicesAnswer = data.joinToString(
                    prefix = "{",
                    separator = ",",
                    postfix = "}",
                ).trim()
                Timber.tag(TAG).d("JoinString: $choicesAnswer")

            }
        })

        return
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {
                if (posisiPertanyaan == jumlahPertanyaan) {
                    finish()
                    Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show()
                } else if (choicesAnswer.isNotEmpty() || choicesAnswer != "") {
                    submitQuisionerChoice()
                    Timber.d("validate_Data : ${validateData()}")
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

    private fun submitQuisionerChoice() {

        val parId: Int = mPreferenceEntity.parId ?: 0

        val quisionerChoicePost = QuisionerAnswerPost(
            endDate = endDate,
            textChoice = choicesAnswer,
            beginDate = beginDate,
            businessCode = "POS",
            participant = parId,
            relationQuesioner = relationQuisionerId.toInt(),
            quesioner = 36,
            )
        viewModel.postQuisionerAnswer(quisionerChoicePost).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "${data.data?.message}", Toast.LENGTH_SHORT).show()
//                        idCount++
//                        getSinglePertanyaan()
//                        choicesAnswer = ""

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


    private fun buildRecycleView() {
        binding.apply {
            adapter = AnswerAdapter()
            recyclerView2.setHasFixedSize(true)
            recyclerView2.layoutManager = LinearLayoutManager(this@QuisionerActivity)
            recyclerView2.adapter = adapter

            adapter.onItemClick = { selectedData ->
                val state = !selectedData.isChecked!!
                setupCheckedAnswerOserver(selectedData, state)
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}

