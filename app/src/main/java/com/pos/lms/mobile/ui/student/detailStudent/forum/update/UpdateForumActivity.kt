package com.pos.lms.mobile.ui.student.detailStudent.forum.update

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.github.dhaval2404.form_validation.rule.NonEmptyRule
import com.github.dhaval2404.form_validation.validation.FormValidator
import com.github.dhaval2404.imagepicker.ImagePicker
import com.pos.lms.core.domain.model.ForumList
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityUpdateForumBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.CurrentTime
import com.pos.lms.mobile.helper.DatePickerFragment
import com.pos.lms.mobile.util.ErrorLog
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
@AndroidEntryPoint
class UpdateForumActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener,
    View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
        private const val PROFILE_IMAGE_REQ_CODE = 101
        private const val DATE_PICKER_TAG_START = "DatePickerStart"
        private const val DATE_PICKER_TAG_END = "DatePickerEnd"
    }

    var token: String? = ""
    var batchId: String? = ""
    var owner: String? = ""
    var time: String? = ""
    var currentDate: String? = ""

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var dataIntent: ForumList? = null
    private var mFile: File? = null
    private var mFileName: String = ""

    private lateinit var binding: ActivityUpdateForumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateForumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataIntent = intent.getParcelableExtra(EXTRA_DATA)
        batchId = dataIntent?.batchId

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        token = mPreferenceEntity.token
        owner = mPreferenceEntity.username
        time = CurrentTime().getCurrentTime()
        currentDate = CurrentDate.getToday()

        binding.btnSave.setOnClickListener(this)
        binding.tvDropdownStartDate.setOnClickListener(this)
        binding.tvDropdownEndDate.setOnClickListener(this)
        binding.tvDropdownImage.setOnClickListener(this)

        // method
        dataIntent?.let { setupDataUpdate(it) }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Update Forum"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupDataUpdate(data: ForumList) {
        binding.apply {
            edtTitle.setText(data.forumTitle)
            edtDescription.setText(data.forumText)
            tvDropdownStartDate.text = data.beginDate
            tvDropdownEndDate.text = data.endDate
        }
    }


    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Set text dari textview once
        when (tag) {
            DATE_PICKER_TAG_START -> binding.tvDropdownStartDate.text =
                dateFormat.format(calendar.time)
            DATE_PICKER_TAG_END -> binding.tvDropdownEndDate.text = dateFormat.format(calendar.time)
            else -> {
                Toast.makeText(this, "Can't find target", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> {
                if (validationField()) {
                    isValidField()
                }
            }

            R.id.tvDropdownStartDate -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(
                    supportFragmentManager,
                    DATE_PICKER_TAG_START
                )
            }

            R.id.tvDropdownEndDate -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(
                    supportFragmentManager,
                    DATE_PICKER_TAG_END
                )
            }
            R.id.tvDropdownImage -> {
                pickPhoto()
            }
        }

    }

    private fun validationField(): Boolean {
        return FormValidator.getInstance()
            .addField(
                binding.edtTitle,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.edtDescription,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownImage,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownStartDate,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownEndDate,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .validate()

    }

    private fun isValidField() {
        val title = binding.edtTitle.text.toString()
        val description = binding.edtDescription.text.toString()
        val startDate = binding.tvDropdownStartDate.text.toString().trim()
        val endDate = binding.tvDropdownEndDate.text.toString().trim()
        val oid = dataIntent?.objectIdentifier

        submitData(title, description, startDate, endDate, oid)
    }

    private fun submitData(
        title: String,
        description: String,
        startDate: String,
        endDate: String,
        oid: String?
    ) {

        binding.progressBar.visibility = View.VISIBLE
//        val url = "${BuildConfig.API_URL}lms/api/forum/update"

        val url = "https://pos-lms.digitalevent.id/lms/api/forum/update"

        Timber.tag("DATA_UPDATE_FORUM")
            .d("oid : $oid , batchId : $batchId , tittle : $title ,  description : $description, time : $time, date : $startDate - $endDate, owner : $owner")

        AndroidNetworking.upload(url)
            .addHeaders("Accept", "application/json")
            .addHeaders("Content-type", "multipart/form-data")
            .addHeaders("Authorization", "Bearer $token")
            .addMultipartParameter("object_identifier", oid)
            .addMultipartParameter("business_code", "POS")
            .addMultipartParameter("batch", batchId)
            .addMultipartParameter("owner", owner)
            .addMultipartParameter("forum_title", title)
            .addMultipartParameter("forum_text", description)
            .addMultipartParameter("forum_type", "1")
            .addMultipartFile("forum_image", mFile)
            .addMultipartParameter("forum_time", time)
            .addMultipartParameter("begin_date", startDate)
            .addMultipartParameter("end_date", endDate)
            .setPriority(Priority.HIGH)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    if (response?.getBoolean("status") == true) {
                        val message = response.getString("message")
                        val status = response.getBoolean("status")
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this@UpdateForumActivity, "Success", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    } else {
                        val message = response?.getString("message")
                        val status = response?.getBoolean("status")
                        Toast.makeText(
                            this@UpdateForumActivity,
                            "Gagal , Periksa Internet Anda",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressBar.visibility = View.GONE

                    }


                }

                override fun onError(anError: ANError?) {
                    binding.progressBar.visibility = View.GONE
                    ErrorLog.errorLog("ForumUpdate", anError, "ForumUpdate")
                    Toast.makeText(this@UpdateForumActivity, "Error", Toast.LENGTH_SHORT).show()

                }

            })


    }

    private fun pickPhoto() {
        ImagePicker.with(this)
            .setImageProviderInterceptor { imageProvider -> // Intercept ImageProvider
                Timber.tag("ImagePicker").d("Selected ImageProvider: %s", imageProvider.name)
            }
            .maxResultSize(1080, 1920)
            .compress(1024)
            .start(PROFILE_IMAGE_REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Activity.RESULT_OK -> {

                Timber.tag("ImagePickerDetail").d("Path:${ImagePicker.getFilePath(data)}")

                val file = ImagePicker.getFile(data)!!
                when (requestCode) {
                    PROFILE_IMAGE_REQ_CODE -> {
                        mFile = file
                        binding.tvDropdownImage.text = ImagePicker.getFilePath(data)
//                    img_result_photo.setLocalImage(file, false)
//                    tv_name_image_helpdesk.text = ImagePicker.getFilePath(data)
//                    uploadFoto = 1
                    }
                    ImagePicker.RESULT_ERROR -> {
                        Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else -> {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}