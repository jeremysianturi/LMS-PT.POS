package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.Schedule
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailScheduleBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner.QuisionerActivity
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailTest.DetailTestActivity
import com.pos.lms.mobile.util.PdfViewActivity
import com.pos.lms.mobile.util.VideoPlayerActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailScheduleActivity : AppCompatActivity() {

    private val tag = DetailScheduleActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val PARENT_DATA = "materi_schedule"
        const val LAYOUT_CODE = "layout_code"
    }

    private val viewModel: DetailScheduleViewModel by viewModels()
    private val binding: ActivityDetailScheduleBinding by viewBinding()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private lateinit var adapterMateri: MateriAdapter
    private lateinit var adapterTest: TestAdapter
    private lateinit var adapterQuisioner: QuisionerAdapter
    private lateinit var adapterTrainer: TrainerAdapter
    private lateinit var adapterRoom: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        val dataIntent = intent.getParcelableExtra<Schedule>(EXTRA_DATA)
        setupObserver(dataIntent)
        setupDataIntent(dataIntent)

//        val layoutCode = intent.getStringExtra(LAYOUT_CODE)
//        if (layoutCode == "STUDENT") {
//            val dataIntent = intent.getParcelableExtra<Schedule>(EXTRA_DATA)
//            setupObserver(dataIntent)
//            setupDataIntent(dataIntent)
//        } else {
//            val dataIntent = intent.getParcelableExtra<TrainerUser>(EXTRA_DATA)
//            setupObserverTrainer(dataIntent)
//            setupDataIntentTrainer(dataIntent)
//        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Schedule"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        buildRecycleView()
    }

    private fun setupDataIntentTrainer(dataIntent: TrainerUser?) {
        if (dataIntent != null) {
            binding.apply {
                tvTitleActivity.text = dataIntent.scheduleName
                with(contentDetailSchedule) {

                    val tittle = "Learning Activity : ${dataIntent.scheduleName}"
                    val topic = "Topic : ${dataIntent.topic}"
                    val begindate = "Begin Date : ${dataIntent.bEGDA}"
                    val enddate = "End Date : ${dataIntent.eNDDA}"
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

    private fun setupObserverTrainer(dataIntent: TrainerUser?) {
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
            Timber.tag(tag).d("fileTypeMateri : ${selectData.fileType}")
            if (selectData.fileType == "VIDEO") {
                val mIntent = Intent(this, VideoPlayerActivity::class.java)
                mIntent.putExtra(VideoPlayerActivity.EXTRA_DATA, selectData)
                mIntent.putExtra(VideoPlayerActivity.PARENT_DATA, PARENT_DATA)
                startActivity(mIntent)
            } else {
                val mIntent = Intent(this, PdfViewActivity::class.java)
                mIntent.putExtra(PdfViewActivity.EXTRA_DATA, selectData)
                mIntent.putExtra(PdfViewActivity.PARENT_DATA, PARENT_DATA)
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

        adapterTest.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailTestActivity::class.java)
            mIntent.putExtra(DetailTestActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)


        }

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}