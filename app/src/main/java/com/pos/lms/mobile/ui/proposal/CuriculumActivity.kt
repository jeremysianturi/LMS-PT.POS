package com.pos.lms.mobile.ui.proposal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.ErrorMessageSplit
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityProposalBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.proposal.create.CreateCuriculumActivity
import com.pos.lms.mobile.ui.proposal.detail.DetailCuriculumActivity
import com.pos.lms.mobile.util.diaolg.SimpleDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CuriculumActivity : AppCompatActivity() {

    private val tag = CuriculumActivity::class.java.simpleName.toString()

    private lateinit var binding: ActivityProposalBinding
    private lateinit var adapter: CuriculumAdapter

    private val curiculumViewModel: CuriculumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProposalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //biar keyboard ga lgsg popup
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.proposal_title)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        // onclick
        binding.ivCrateProposal.setOnClickListener {
            val mIntent = Intent(this, CreateCuriculumActivity::class.java)
            startActivity(mIntent)
        }

        // search
        binding.edtSearchProposal.doOnTextChanged { text, start, before, count ->
            curiculumViewModel.searchQuery.value = text.toString()
        }

        // method
        setupObserver(begda, enda)
        buildList()
    }

    private fun setupObserver(begda: String, enda: String) {

        curiculumViewModel.getCuriculum(begda, enda).observe(this, { data ->
            Timber.tag(tag).d("observer_curiculum $data")
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarProposal.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBarProposal.visibility = View.GONE
                        adapter.setData(data.data)
                        Timber.tag(tag).d("observer_curiculum_adapter ${data.data}")
                    }
                    is Resource.Error -> {
                        binding.progressBarProposal.visibility = View.GONE
                        val message = ErrorMessageSplit.message(data.message.toString())
                        val code = ErrorMessageSplit.code(data.message.toString())
                        SimpleDialog.newInstance(code, message)
                            .show(supportFragmentManager, SimpleDialog.TAG)
                    }
                }

            }
        })

        curiculumViewModel.search.observe(this, { data ->
            adapter.setData(data)

        })


    }

    private fun buildList() {

        adapter = CuriculumAdapter()
        binding.rvProposal.setHasFixedSize(true)
        binding.rvProposal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProposal.adapter = adapter

        binding.rvProposal.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailCuriculumActivity::class.java)
            mIntent.putExtra(DetailCuriculumActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}