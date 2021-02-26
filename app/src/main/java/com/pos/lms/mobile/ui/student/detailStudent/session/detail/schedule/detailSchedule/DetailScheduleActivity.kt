package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Schedule
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailScheduleBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner.QuisionerActivity
import com.pos.lms.mobile.util.VideoPlayerActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScheduleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailScheduleViewModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private lateinit var adapterMateri: MateriAdapter
    private lateinit var adapterTest: TestAdapter
    private lateinit var adapterQuisioner: QuisionerAdapter
    private lateinit var adapterTrainer: TrainerAdapter
    private lateinit var adapterRoom: RoomAdapter

    private lateinit var binding: ActivityDetailScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        val dataIntent = intent.getParcelableExtra<Schedule>(EXTRA_DATA)


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Schedule"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        setupObserver(dataIntent)
        buildRecycleView()
        setupDataIntent(dataIntent)
    }

    private fun setupObserver(dataIntent: Schedule?) {

        val beginDate = CurrentDate.getToday()
        val endDate = CurrentDate.getToday()
        val parent = dataIntent?.scheduleId.toString()

        viewModel.getMateri(parent, beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterMateri.setData(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getTest(parent, beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterTest.setData(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getQuisioner(parent, beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterQuisioner.setData(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getTrainer(parent, beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterTrainer.setData(data.data)
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getRoom(parent, beginDate, endDate).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterRoom.setData(data.data)
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

        // materi
        adapterMateri = MateriAdapter()
        binding.rvMateri.setHasFixedSize(true)
        binding.rvMateri.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMateri.adapter = adapterMateri

        // item Decoration
        binding.rvMateri.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapterMateri.onItemClick = { selectData ->
            if (selectData.fileType == "VIDEO") {
                val mIntent = Intent(this, VideoPlayerActivity::class.java)
                mIntent.putExtra(VideoPlayerActivity.EXTRA_DATA, selectData)
                startActivity(mIntent)
            } else {
                val mIntent = Intent(this, VideoPlayerActivity::class.java)
                mIntent.putExtra(VideoPlayerActivity.EXTRA_DATA, selectData)
                startActivity(mIntent)
            }


        }

        // Test
        adapterTest = TestAdapter()
        binding.rvTest.setHasFixedSize(true)
        binding.rvTest.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTest.adapter = adapterTest

        // item Decoration
        binding.rvTest.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

//        adapter.onItemClick = { selectData ->
//            val mIntent = Intent(requireContext(), DetailScheduleActivity::class.java)
//            mIntent.putExtra(DetailScheduleActivity.EXTRA_DATA, selectData)
//            startActivity(mIntent)
//
//
//        }

        // Quisioner
        adapterQuisioner = QuisionerAdapter()
        binding.rvQuisioner.setHasFixedSize(true)
        binding.rvQuisioner.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvQuisioner.adapter = adapterQuisioner

        // item Decoration
        binding.rvQuisioner.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapterQuisioner.onItemClick = { selectData ->
            val mIntent = Intent(this, QuisionerActivity::class.java)
            mIntent.putExtra(QuisionerActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)


        }

        // Trainer
        adapterTrainer = TrainerAdapter()
        binding.rvTrainer.setHasFixedSize(true)
        binding.rvTrainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTrainer.adapter = adapterTrainer

        // item Decoration
        binding.rvTrainer.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        // Room
        adapterRoom = RoomAdapter()
        binding.rvRoom.setHasFixedSize(true)
        binding.rvRoom.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRoom.adapter = adapterRoom

        // item Decoration
        binding.rvRoom.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )


    }

    private fun setupDataIntent(dataIntent: Schedule?) {
        if (dataIntent != null) {
            binding.apply {
                tvTitleActivity.text = dataIntent.scheduleName
                with(contentDetailSchedule) {

                    val tittle = "Learning Activity : ${dataIntent.scheduleName}"
                    val topic = "Topic : ${dataIntent.topic}"
                    val begindate = "Begin Date : ${dataIntent.beginDate}"
                    val enddate = "End Date : ${dataIntent.endDate}"
                    val time = "Time : ${dataIntent.beginTime} - ${dataIntent.endTime}"

                    tvLearningActivity.text = tittle
                    tvTopic.text = topic
                    tvBeginDate.text = begindate
                    tvEndDate.text = enddate
                    tvTime.text = time

                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}