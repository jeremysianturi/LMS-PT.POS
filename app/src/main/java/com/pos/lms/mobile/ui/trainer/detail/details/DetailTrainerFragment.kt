package com.pos.lms.mobile.ui.trainer.detail.details

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailScheduleBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.*
import com.pos.lms.mobile.util.PdfViewActivity
import com.pos.lms.mobile.util.VideoPlayerActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailTrainerFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailScheduleViewModel by viewModels()
    private val binding: ActivityDetailScheduleBinding by viewBinding()

    private lateinit var adapterMateri: MateriAdapter
    private lateinit var adapterTrainer: TrainerAdapter
    private lateinit var adapterRoom: RoomAdapter
    //    private lateinit var adapterTest: TestAdapter
    //    private lateinit var adapterQuisioner: QuisionerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_detail_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            val dataBundle = bundle.getParcelable(EXTRA_DATA) as TrainerUser?
            setupDataIntentTrainer(dataBundle)
            setupObserverTrainer(dataBundle)
        }
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

    private fun setupObserverTrainer(dataIntent: TrainerUser?) {
        val beginDate = CurrentDate.getToday()
        val endDate = CurrentDate.getToday()
        val parent = dataIntent?.scheduleId.toString()

        viewModel.getMateri(parent, beginDate, endDate).observe(requireActivity(), { data ->
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
                        Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getTrainer(parent, beginDate, endDate).observe(requireActivity(), { data ->
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
                        Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

        viewModel.getRoom(parent, beginDate, endDate).observe(requireActivity(), { data ->
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
                        Toast.makeText(requireContext(), loginMessage, Toast.LENGTH_SHORT).show()
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
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMateri.adapter = adapterMateri

        // item Decoration
        binding.rvMateri.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        adapterMateri.onItemClick = { selectData ->
            Timber.tag(tag).d("fileTypeMateri : ${selectData.fileType}")
            if (selectData.fileType == "VIDEO") {
                val mIntent = Intent(requireContext(), VideoPlayerActivity::class.java)
                mIntent.putExtra(VideoPlayerActivity.EXTRA_DATA, selectData)
                mIntent.putExtra(
                    VideoPlayerActivity.PARENT_DATA,
                    DetailScheduleActivity.PARENT_DATA
                )
                startActivity(mIntent)
            } else {
                val mIntent = Intent(requireContext(), PdfViewActivity::class.java)
                mIntent.putExtra(PdfViewActivity.EXTRA_DATA, selectData)
                mIntent.putExtra(PdfViewActivity.PARENT_DATA, DetailScheduleActivity.PARENT_DATA)
                startActivity(mIntent)
            }


        }

//        // Test
//        adapterTest = TestAdapter()
//        binding.rvTest.setHasFixedSize(true)
//        binding.rvTest.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.rvTest.adapter = adapterTest
//
//        // item Decoration
//        binding.rvTest.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                LinearLayoutManager.VERTICAL
//            )
//        )
//
//        adapterTest.onItemClick = { selectData ->
//            val mIntent = Intent(this, DetailTestActivity::class.java)
//            mIntent.putExtra(DetailTestActivity.EXTRA_DATA, selectData)
//            startActivity(mIntent)
//
//
//        }
//
//        // Quisioner
//        adapterQuisioner = QuisionerAdapter()
//        binding.rvQuisioner.setHasFixedSize(true)
//        binding.rvQuisioner.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.rvQuisioner.adapter = adapterQuisioner
//
//        // item Decoration
//        binding.rvQuisioner.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                LinearLayoutManager.VERTICAL
//            )
//        )
//
//        adapterQuisioner.onItemClick = { selectData ->
//            val mIntent = Intent(this, QuisionerActivity::class.java)
//            mIntent.putExtra(QuisionerActivity.EXTRA_DATA, selectData)
//            startActivity(mIntent)
//
//
//        }

        // Trainer
        adapterTrainer = TrainerAdapter()
        binding.rvTrainer.setHasFixedSize(true)
        binding.rvTrainer.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTrainer.adapter = adapterTrainer

        // item Decoration
        binding.rvTrainer.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        // Room
        adapterRoom = RoomAdapter()
        binding.rvRoom.setHasFixedSize(true)
        binding.rvRoom.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvRoom.adapter = adapterRoom

        // item Decoration
        binding.rvRoom.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )


    }


}