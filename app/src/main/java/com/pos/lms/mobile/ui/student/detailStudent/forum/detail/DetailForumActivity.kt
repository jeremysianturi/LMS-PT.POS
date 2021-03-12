package com.pos.lms.mobile.ui.student.detailStudent.forum.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.dhaval2404.form_validation.rule.NonEmptyRule
import com.github.dhaval2404.form_validation.validation.FormValidator
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.ForumCommnetPost
import com.pos.lms.core.domain.model.ForumList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityDetailForumBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.CurrentTime
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class DetailForumActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailForumBinding
    private val viewModel: DetailForumViewModel by viewModels()
    private lateinit var adapter: DetailForumAdapter

    var forumId: String? = ""
    var startDate: String? = ""
    var endDate: String? = ""
    private var currentTime: String? = ""
    private var ownerId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailForumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent.getParcelableExtra<ForumList>(EXTRA_DATA)

        forumId = dataIntent?.forumId.toString()
        startDate = CurrentDate.getToday()
        endDate = CurrentDate.getToday()
        currentTime = CurrentTime().getCurrentTime()
        ownerId = dataIntent?.owner

        // method
        buildRc()
        setupData(dataIntent)
        setupObserver()

        //onclick
        binding.ivComment.setOnClickListener {
            if (validationField()) {
                isValid()
            } else {
                Toast.makeText(this, "comment field empty", Toast.LENGTH_SHORT).show()
            }

        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Detail Forum"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupObserver() {
        viewModel.getComment(forumId.toString(), startDate.toString(), endDate.toString())
            .observe(this, { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding.progressBarForum.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBarForum.visibility = View.GONE
                            adapter.setData(data.data)
                        }
                        is Resource.Error -> {
                            val loginMessage = getString(R.string.something_wrong)
                            binding.progressBarForum.visibility = View.GONE
                            Toast.makeText(this, loginMessage, Toast.LENGTH_SHORT).show()
                        }
                    }

                }

            })
    }

    private fun buildRc() {
        adapter = DetailForumAdapter()
        binding.rvComment.setHasFixedSize(true)
        binding.rvComment.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvComment.adapter = adapter

        binding.rvComment.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

//        adapter.onItemClick = { selectData ->
//            val mIntent = Intent(this, DetailMateriActivity::class.java)
//            mIntent.putExtra(DetailMateriActivity.EXTRA_DATA, selectData)
//            startActivity(mIntent)
//        }
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

    private fun submitComment(comment: String) {

        // create json object data

        val postComment = ForumCommnetPost(
            otypeParent = "SCDHL",
            forum = forumId,
            owner = ownerId,
            beginDate = startDate,
            beginTime = currentTime,
            businessCode = "POS",
            comment = comment
        )

        viewModel.postComment(postComment).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBarForum.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        val message = data.message.toString()
                        Timber.d("messageUpdate $message")

                        val msg = "Success"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        binding.progressBarForum.visibility = View.GONE
                        binding.edtComment.setText("")
                        setupObserver()
                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBarForum.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

    }


    private fun setupData(data: ForumList?) {
        binding.apply {

            val subtitle = "${data?.owner} - ${data?.forumTime}"

            tvTittleForum.text = data?.forumTitle ?: "-"
            tvSubTittle.text = subtitle
            tvDescription.text = data?.forumText ?: ""
            tvContenLike.text = "0"

            Glide.with(this@DetailForumActivity)
                .load(data?.forumImage)
                .error(R.drawable.dummy_images)
                .into(imageView9)
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}