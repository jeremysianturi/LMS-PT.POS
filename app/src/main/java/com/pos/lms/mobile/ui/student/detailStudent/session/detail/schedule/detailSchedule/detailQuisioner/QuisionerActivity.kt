package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.QuisionerAnswer
import com.pos.lms.core.domain.model.QuisionerSchedule
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityQuisionerBinding
import com.pos.lms.mobile.helper.CurrentDate
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class QuisionerActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = QuisionerActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityQuisionerBinding
    private lateinit var adapter: AnswerAdapter

    private val viewModel: QuisionerVieModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

//    private lateinit var questions: List<QuisionerQuisEntity>

    private var quisionerId: String? = "0"

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuisionerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        val dataIntent = intent.getParcelableExtra<QuisionerSchedule>(EXTRA_DATA)

        val beginDate = CurrentDate.getToday()
        val endDate = CurrentDate.getToday()
        quisionerId = "36" // harcode sampai api Pertanyaan Quisioner selesai


        // method
        buildRecycleView()
        setupObserver(beginDate, endDate)

        // onclick
        binding.btnNext.setOnClickListener(this)

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Quisioner Activity"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupObserver(beginDate: String, endDate: String) {
        viewModel.getQuisionerAnswer(quisionerId.toString(), beginDate, endDate)
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

        viewModel.getCheckedAnswer().observe(this, { data ->
            adapter.setData(data)
            Timber.tag("ANSWER_DATA").d("$data")
        })


    }

    private fun setupCheckedAnswerOserver(selectedData: QuisionerAnswer, state: Boolean) {
        viewModel.setChecketQuisionerUpdate(selectedData, state)
    }

//    private fun setupdata(data: List<QuisionerQuisEntity>, counter: Int) {
//        binding.apply {
//
//            val countQuestions =
//                "Question : ${data[counter].no} / ${data[this@QuisionerActivity.count].total}"
//
//            tvCountQuestion.text = countQuestions
//            tvTypeQuestion.text = data[counter].type
//            tvQuestion.text = data[counter].question
//            tvQuestionDesc.text = data[counter].description
//        }
//
//    }

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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNext -> {

//                count++
//                Log.d(TAG, "counter : $count")
//                val counter = count++
//                setupdata(questions, counter)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}

