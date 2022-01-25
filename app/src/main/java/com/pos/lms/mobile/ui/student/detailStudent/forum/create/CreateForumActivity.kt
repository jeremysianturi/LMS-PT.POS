package com.pos.lms.mobile.ui.student.detailStudent.forum.create

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.bumptech.glide.Glide
import com.github.dhaval2404.form_validation.rule.NonEmptyRule
import com.github.dhaval2404.form_validation.validation.FormValidator
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pos.lms.core.data.source.remote.response.SubmitResponse
import com.pos.lms.core.domain.model.Student
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityCreateForumBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.CurrentTime
import com.pos.lms.mobile.helper.DatePickerFragment
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.MultipartBody.Part.Companion.createFormData
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import timber.log.Timber
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class CreateForumActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener,
    View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val USER_ROLE = "user_role"
        private const val PROFILE_IMAGE_REQ_CODE = 101
        private const val DATE_PICKER_TAG_START = "DatePickerStart"
        private const val DATE_PICKER_TAG_END = "DatePickerEnd"
    }

    //bottomSheet
    private var bottomSheetDialog: BottomSheetDialog? = null

    private lateinit var binding: ActivityCreateForumBinding
    private val viewModel: CreateForumViewModel by viewModels()

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    var token: String? = ""
    var batchId: String? = ""
    var owner: String? = ""
    var time: String? = ""
    var currentDate: String? = ""

    private var mFile: File? = null
    private var mFileName: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateForumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialog)

        val userrole = intent.getStringExtra(USER_ROLE)

        batchId = if (userrole == "STUDENT") {
            val dataIntent = intent.getParcelableExtra<Student>(EXTRA_DATA)
            dataIntent?.batch.toString()
        } else {
            val dataIntent = intent.getParcelableExtra<TrainerUser>(EXTRA_DATA)
            dataIntent?.batch.toString()
        }

        token = mPreferenceEntity.token
        owner = mPreferenceEntity.username
        time = CurrentTime().getCurrentTime()
        currentDate = CurrentDate.getToday()

        // onclick
        binding.btnSave.setOnClickListener(this)
        binding.tvDropdownStartDate.setOnClickListener(this)
        binding.tvDropdownEndDate.setOnClickListener(this)
        binding.tvDropdownImage.setOnClickListener(this)


        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Create Forum"
        actionbar?.setDisplayHomeAsUpEnabled(true)
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
        popupConfirm()
    }

    private fun popupConfirm() {
        //init bottomSheet
        val views = layoutInflater.inflate(R.layout.bottom_sheet_confirmation, null)
        bottomSheetDialog?.setContentView(views)
        val tittle = views.findViewById<TextView>(R.id.tvDialogTittle)
        val content = views.findViewById<TextView>(R.id.tvDialogMessage)
        val btnNo = views.findViewById<Button>(R.id.btnDialogNo)
        val btnYes = views.findViewById<Button>(R.id.btnDialogYes)

        tittle.text = getString(R.string.txt_konfirmasi)
        content.text = getString(R.string.txt_konfirmasi_content)
        btnNo.text = getString(R.string.text_batal)
        btnYes.text = getString(R.string.text_oke)
        bottomSheetDialog?.show()

        //onclick bottomsheet
        // positive button
        btnYes.setOnClickListener {
            submitData()
            bottomSheetDialog?.dismiss()
        }
        // negative button
        btnNo.setOnClickListener {
            bottomSheetDialog?.dismiss()
        }

    }

    private fun popupInformation() {

        val views = layoutInflater.inflate(R.layout.bottom_sheet_information, null)
        bottomSheetDialog?.setContentView(views)

        val tittle = views.findViewById<TextView>(R.id.tvTittleInfo)
        val content = views.findViewById<TextView>(R.id.tvContentInfo)
        val btnYes = views.findViewById<Button>(R.id.btnInfo)
        val img = views.findViewById<ImageView>(R.id.imgInfo)
        tittle.text = getString(R.string.text_berhasil)
        content.text = getString(R.string.txt_confirm_curiculum)
        Glide.with(this)
            .load(R.drawable.img_confirm)
            .into(img)

        btnYes.text = getString(R.string.text_oke)
        bottomSheetDialog?.show()

        //setOnclick bottomsheet
        btnYes.setOnClickListener {
            bottomSheetDialog?.dismiss()
            finish()
        }

    }

    private fun submitData() {

        binding.progressBar.visibility = View.VISIBLE

        val title = binding.edtTitle.text.toString()
        val description = binding.edtDescription.text.toString()
        val startDate = binding.tvDropdownStartDate.text.toString().trim()
        val endDate = binding.tvDropdownEndDate.text.toString().trim()

        // sementara selama retrofit blm bisa upload image "Lebih ke tolol sih "
        AndroidNetworking.upload("${com.pos.lms.core.BuildConfig.API_URL}lms/api/forum")
            .addHeaders("Accept", "application/json")
            .addHeaders("Content-type", "multipart/form-data")
            .addHeaders("Authorization", "Bearer $token")
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
                        val responseSubmit = SubmitResponse(message, status)
                        binding.progressBar.visibility = View.GONE
                        popupInformation()

                    } else {
                        val message = response?.getString("message")
                        val status = response?.getBoolean("status")
                        val responseSubmit = SubmitResponse(message.toString(), status!!)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this@CreateForumActivity, "Failed", Toast.LENGTH_SHORT)
                            .show()

                    }


                }

                override fun onError(anError: ANError?) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@CreateForumActivity, "Error", Toast.LENGTH_SHORT).show()

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

                Timber.tag("ImagePickerDetail").e("Path:${ImagePicker.getFilePath(data)}")

                val file = ImagePicker.getFile(data)!!
                val name = ImagePicker.getFilePath(data)
                when (requestCode) {
                    PROFILE_IMAGE_REQ_CODE -> {
                        mFile = file
                        mFileName = name.toString()
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

//    private fun submitData(title: String, description: String, startDate: String, endDate: String) {
///*
//        @Part("business_code") businessode : RequestBody,
//        @Path("batch") batchid : RequestBody,
//        @Path("owner") owner : RequestBody,
//        @Path("forum_title") forumTitle : RequestBody,
//        @Path("forum_text") forumText : RequestBody,
//        @Path("forum_type") forumType : RequestBody,
//        @Path("forum_image") forumImage : MultipartBody.Part,
//        @Path("forum_time") forumTime : RequestBody,
//        @Path("begin_date") beginDate : RequestBody,
//        @Path("end_date") endDate : RequestBody,
//*/
//        val bussinessCode = "POS"
//        val types = "1"
//
//        val name = "myFile"
//        val file: File? = mFile
//        val requestBody = file?.asRequestBody("image/*".toMediaTypeOrNull())
//        val image: MultipartBody.Part = createFormData("Images", name, requestBody!!)
//
//        // new
//        val businesCode: RequestBody = "POS".toRequestBody("text/plain".toMediaTypeOrNull())
//        val batch: RequestBody = batchId!!.toRequestBody("text/plain".toMediaTypeOrNull())
//        val owner: RequestBody = owner!!.toRequestBody("text/plain".toMediaTypeOrNull())
//        val tittle: RequestBody = title.toRequestBody("text/plain".toMediaTypeOrNull())
//        val desc: RequestBody = description.toRequestBody("text/plain".toMediaTypeOrNull())
//        val type: RequestBody = "1".toRequestBody("text/plain".toMediaTypeOrNull())
//        val time: RequestBody = time!!.toRequestBody("text/plain".toMediaTypeOrNull())
//        val begda: RequestBody = startDate.toRequestBody("text/plain".toMediaTypeOrNull())
//        val endda: RequestBody = endDate.toRequestBody("text/plain".toMediaTypeOrNull())
//
//        //old
////        val requestFile: RequestBody = mFile!!.asRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val businesCode: RequestBody =
////            bussinessCode.toRequestBody("text/Palin-data".toMediaTypeOrNull())
////        val batch: RequestBody = batchId!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val owner: RequestBody = owner!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val tittle: RequestBody = title.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val desc: RequestBody = description.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val type: RequestBody = types.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val image: MultipartBody.Part = createFormData("image", mFileName, requestFile)
////        val time: RequestBody = time!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val begda: RequestBody = startDate.toRequestBody("multipart/form-data".toMediaTypeOrNull())
////        val endda: RequestBody = endDate.toRequestBody("multipart/form-data".toMediaTypeOrNull())
//
//        viewModel.createForum(
//            businesCode,
//            batch,
//            owner,
//            tittle,
//            desc,
//            type,
//            image,
//            time,
//            begda,
//            endda
//        ).observe(this, { data ->
//            if (data != null) {
//                when (data) {
//                    is Resource.Loading -> {
//                        binding.progressBar.visibility = View.VISIBLE
//                    }
//
//                    is Resource.Success -> {
//                        val message = data.message.toString()
//                        Timber.d("messageUpdate $message")
//
//                        val msg = "Create Success"
//                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                        binding.progressBar.visibility = View.GONE
//
//                        finish()
//
//                    }
//
//                    is Resource.Error -> {
//                        val massage = getString(R.string.something_wrong)
//                        binding.progressBar.visibility = View.GONE
//                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//
//        })
//
//
//    }

    private fun uploadImage() {
        val file: File? = mFile
        val requestBody = file?.asRequestBody("image/*".toMediaTypeOrNull())
        val parts: MultipartBody.Part = createFormData("newimage", file?.name, requestBody!!)
        val someData = "This is a new Image".toRequestBody("text/plain".toMediaTypeOrNull())
//
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}