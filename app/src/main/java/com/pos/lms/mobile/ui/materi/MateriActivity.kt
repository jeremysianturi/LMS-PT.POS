package com.pos.lms.mobile.ui.materi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pos.lms.core.data.Resource
import com.pos.lms.core.utils.ErrorMessageSplit
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityMateriBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.ui.materi.detail.DetailMateriActivity
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
class MateriActivity : AppCompatActivity() {

    private val tag = MateriActivity::class.java.simpleName.toString()

    private lateinit var binding: ActivityMateriBinding

    private lateinit var adapter: MateriAdapter

    private val materiViewmodel: MateriViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.txt_materi)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        // search
        binding.edtSearchMateri.doOnTextChanged { text, start, before, count ->
            materiViewmodel.searchQuery.value = text.toString()
        }

        //method
        setupObserver(begda, enda)
        buildRc()

    }

    private fun buildRc() {

        adapter = MateriAdapter()

        binding.rvMateri.setHasFixedSize(true)
        binding.rvMateri.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMateri.adapter = adapter

        binding.rvMateri.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemClick = { selectData ->
            val mIntent = Intent(this, DetailMateriActivity::class.java)
            mIntent.putExtra(DetailMateriActivity.EXTRA_DATA, selectData)
            startActivity(mIntent)
        }
    }

    private fun setupObserver(begda: String, enda: String) {
        materiViewmodel.getMateri(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBarMateri.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBarMateri.visibility = View.GONE
                        adapter.setData(data.data)
                        Timber.tag(tag).d("observer_Materi_adapter ${data.data}")
                    }
                    is Resource.Error -> {
                        binding.progressBarMateri.visibility = View.GONE
                        val message = ErrorMessageSplit.message(data.message.toString())
                        val code = ErrorMessageSplit.code(data.message.toString())
                        SimpleDialog.newInstance(code, message)
                            .show(supportFragmentManager, SimpleDialog.TAG)
                    }
                }

            }

        })

        materiViewmodel.search.observe(this, { data ->
            adapter.setData(data)

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}