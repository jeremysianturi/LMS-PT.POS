package com.pos.lms.mobile.ui.mentor.detail

import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.dhaval2404.form_validation.rule.NonEmptyRule
import com.github.dhaval2404.form_validation.validation.FormValidator
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.MentoringChatPost
import com.pos.lms.core.domain.model.MentorUser
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailMentorBinding
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.detail.DetailMentoringViewModel
import com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.detail.MentoringChatAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class DetailMentorActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val binding: ActivityDetailMentorBinding by viewBinding()
    private val viewModel: DetailMentoringViewModel by viewModels()
    private lateinit var adapter: MentoringChatAdapter

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var mentoringId: Int? = 0
    private var dataIntent: MentorUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        dataIntent = intent.getParcelableExtra(EXTRA_DATA)

        mentoringId = dataIntent?.mentoring ?: 0

        buildRecycleView()
        setupObserver()
        dataIntent?.let { collectData(it) }

        // onclick
        binding.ivComment.setOnClickListener {
            if (validationField()) {
                isValid()
            }

        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Mentor"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun buildRecycleView() {

        adapter = MentoringChatAdapter()
        binding.rvChat.setHasFixedSize(true)
        binding.rvChat.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvChat.adapter = adapter

        // item Decoration
        binding.rvChat.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Mentor"
        actionbar?.setDisplayHomeAsUpEnabled(true)


    }

    private fun validationField(): Boolean {
        return FormValidator.getInstance()
            .addField(
                binding.edtComment,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .validate()
    }

    private fun isValid() {
        val comment = binding.edtComment.text.toString()
        submitComment(comment)
    }

    private fun setupObserver() {

        val mentoringId = dataIntent?.mentoring

        viewModel.getChat(mentoringId.toString()).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        adapter.setData(data.data)

                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar2.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

    }

    private fun submitComment(comment: String) {

        // create json object data
        val dataComment = JSONObject()

        dataComment.put("business_code", "POS")
        dataComment.put("mentoring", mentoringId)
        dataComment.put("otype", "TEXT")
        dataComment.put("sender", mPreferenceEntity.parId)
        dataComment.put("sender_type", "PARTI")
        dataComment.put("text", comment)


        val entities = MentoringChatPost(
            sender = mPreferenceEntity.parId!!,
            senderType = "PARTI",
            businessCode = "POS",
            mentoring = mentoringId!!,
            otype = "TEXT",
            text = comment

        )

        viewModel.postChat(entities).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar2.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar2.visibility = View.GONE
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        binding.edtComment.setText("")
                        setupObserver()
                    }
                    is Resource.Error -> {
                        val loginMessage = getString(R.string.something_wrong)
                        binding.progressBar2.visibility = View.GONE
                        Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })


    }

    private fun collectData(data: MentorUser) {

        binding.contentDetail.tvContentTitle.text = data.mentoringTitle ?: ""
        binding.contentDetail.tvContentTopic.text = data.mentoringTopic ?: ""
        binding.contentDetail.tvContentDescription.text = data.mentoringDescription ?: ""
        binding.contentDetail.tvContentLink.text = "-"

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}