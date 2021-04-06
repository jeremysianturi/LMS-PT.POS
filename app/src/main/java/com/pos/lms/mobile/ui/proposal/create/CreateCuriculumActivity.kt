package com.pos.lms.mobile.ui.proposal.create

import `in`.galaxyofandroid.spinerdialog.SpinnerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.dhaval2404.form_validation.rule.NonEmptyRule
import com.github.dhaval2404.form_validation.validation.FormValidator
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.CuriculumCreate
import com.pos.lms.core.domain.model.Company
import com.pos.lms.core.domain.model.Competency
import com.pos.lms.core.domain.model.PL
import com.pos.lms.core.domain.model.Type
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityCreateCompetencyBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.DatePickerFragment
import com.pos.lms.mobile.helper.Debounce.onThrottledClick
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class CreateCuriculumActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerFragment.DialogDateListener {

    private lateinit var binding: ActivityCreateCompetencyBinding

    //bottomSheet
    private var bottomSheetDialog: BottomSheetDialog? = null

    private val viewmodel: CreateCuriculumViewModel by viewModels()

    companion object {
        private const val DATE_PICKER_TAG_START = "DatePickerStart"
        private const val DATE_PICKER_TAG_END = "DatePickerEnd"
    }

    //spinner
    private val listSpinCompany = ArrayList<Company>()
    private val listSpinCompanyName = ArrayList<String>()
    private val listSpinCompetency = ArrayList<Competency>()
    private val listSpinCompetencyName = ArrayList<String>()
    private val listSpinType = ArrayList<Type>()
    private val listSpinTypeName = ArrayList<String>()
    private val listSpinProficiencyLevel = ArrayList<PL>()
    private val listSpinProficiencyLevelName = ArrayList<String>()

    // variable untuk post
    private var idCompany: String? = ""
    private var idType: String? = ""
    private var idCompentency: String? = ""
    private var idLevel: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCompetencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()

        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialog)

        // onclick
        binding.tvDropdownType.setOnClickListener(this)
        binding.tvDropdownCompany.setOnClickListener(this)
        binding.tvDropdownCompetency.setOnClickListener(this)
        binding.tvDropdownLevel.setOnClickListener(this)
        binding.tvDropdownStartDate.setOnClickListener(this)
        binding.tvDropdownEndDate.setOnClickListener(this)

//        binding.btnSave.setOnClickListener(this)
        binding.btnSave.onThrottledClick {
            if (validationField()) {
                isValidField()
            } else {
                Toast.makeText(this, "Lengkapi data terlebih dahulu !", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Create Curiculum"
        actionbar?.setDisplayHomeAsUpEnabled(true)

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

    private fun setupObserver() {

        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()

        viewmodel.getCompany(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        listSpinCompany.clear()
                        listSpinCompanyName.clear()
                        data.data?.let { listSpinCompany.addAll(it) }

                        for (i in data.data?.indices!!) {
                            val name = data.data!![i].companyName
                            listSpinCompanyName.add(name)

                        }
                        binding.progressBar.visibility = View.GONE

                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })


        viewmodel.getCompetency(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        listSpinCompetency.clear()
                        listSpinCompetencyName.clear()
                        data.data?.let { listSpinCompetency.addAll(it) }

                        for (i in data.data?.indices!!) {
                            val name = data.data!![i].longText
                            listSpinCompetencyName.add(name)

                        }
                        binding.progressBar.visibility = View.GONE

                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

        viewmodel.getPL(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        listSpinProficiencyLevel.clear()
                        listSpinProficiencyLevelName.clear()
                        data.data?.let { listSpinProficiencyLevel.addAll(it) }

                        for (i in data.data?.indices!!) {
                            val name = data.data!![i].longText
                            listSpinProficiencyLevelName.add(name)

                        }
                        binding.progressBar.visibility = View.GONE

                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
        viewmodel.getType(begda, enda).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        listSpinType.clear()
                        listSpinTypeName.clear()
                        data.data?.let { listSpinType.addAll(it) }

                        for (i in data.data?.indices!!) {
                            val name = data.data!![i].longText
                            listSpinTypeName.add(name)

                        }
                        binding.progressBar.visibility = View.GONE

                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvDropdownCompany -> {
                val spinnerDialog = SpinnerDialog(
                    this,
                    listSpinCompanyName,
                    "Select Item : ",
                    R.style.DialogAnimations_SmileWindow
                )

                spinnerDialog.bindOnSpinerListener { s, i ->
                    binding.tvDropdownCompany.text = s
                    idCompany = listSpinCompany[i].businessCode
                }
                spinnerDialog.showSpinerDialog()

            }

            R.id.tvDropdownType -> {
                val spinnerDialog = SpinnerDialog(
                    this,
                    listSpinTypeName,
                    "Select Item : ",
                    R.style.DialogAnimations_SmileWindow
                )

                spinnerDialog.bindOnSpinerListener { s, i ->
                    binding.tvDropdownType.text = s
                    idType = listSpinType[i].shortText
                }
                spinnerDialog.showSpinerDialog()

            }

            R.id.tvDropdownCompetency -> {
                val spinnerDialog = SpinnerDialog(
                    this,
                    listSpinCompetencyName,
                    "Select Item : ",
                    R.style.DialogAnimations_SmileWindow
                )

                spinnerDialog.bindOnSpinerListener { s, i ->
                    binding.tvDropdownCompetency.text = s
                    idCompentency = listSpinCompetency[i].shortText
                }
                spinnerDialog.showSpinerDialog()
            }

            R.id.tvDropdownLevel -> {
                val spinnerDialog = SpinnerDialog(
                    this,
                    listSpinProficiencyLevelName,
                    "Select Item : ",
                    R.style.DialogAnimations_SmileWindow
                )

                spinnerDialog.bindOnSpinerListener { s, i ->
                    binding.tvDropdownLevel.text = s
                    idLevel = listSpinProficiencyLevel[i].shortText

                }
                spinnerDialog.showSpinerDialog()
            }

            R.id.tvDropdownStartDate -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG_START)
            }

            R.id.tvDropdownEndDate -> {
                val datePickerFragment = DatePickerFragment()
                datePickerFragment.show(supportFragmentManager, DATE_PICKER_TAG_END)
            }


        }
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {

        // Siapkan date formatter-nya terlebih dahulu
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

    private fun validationField(): Boolean {
        return FormValidator.getInstance()
            .addField(
                binding.tvDropdownCompany,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.edtCuriculumnRequestName,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.edtCuriculumnDeskripsi,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownType,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownCompetency,
                NonEmptyRule(getString(R.string.ERROR_FIELD_REQUIRED))
            )
            .addField(
                binding.tvDropdownLevel,
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

    private fun submitData() {

        val startDate = binding.tvDropdownStartDate.text.toString()
        val endDate = binding.tvDropdownEndDate.text.toString()
        val requestName = binding.edtCuriculumnRequestName.text.toString()
        val desc = binding.edtCuriculumnDeskripsi.text.toString()

        val createCuriculum = CuriculumCreate(
            endDate = endDate,
            requestName = requestName,
            competence = idCompentency.toString(),
            requestType = idType.toString(),
            beginDate = startDate,
            businessCode = idCompany.toString(),
            requestDescription = desc,
            plCode = idLevel.toString(),

            )

        viewmodel.createCuriculum(createCuriculum).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        val message = data.message.toString()
                        Timber.d("messageUpdate $message")

                        val msg = "Create Success"
                        binding.progressBar.visibility = View.GONE

                        popupInformation()

                    }

                    is Resource.Error -> {
                        val massage = getString(R.string.something_wrong)
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}