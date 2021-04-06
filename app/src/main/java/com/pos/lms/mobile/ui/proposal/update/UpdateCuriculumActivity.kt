package com.pos.lms.mobile.ui.proposal.update

import `in`.galaxyofandroid.spinerdialog.SpinnerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.post.CuriculumUpdate
import com.pos.lms.core.domain.model.*
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityUpdateCuriculumBinding
import com.pos.lms.mobile.helper.CurrentDate
import com.pos.lms.mobile.helper.DatePickerFragment
import com.pos.lms.mobile.helper.Debounce.onThrottledClick
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class UpdateCuriculumActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerFragment.DialogDateListener {

    private lateinit var binding: ActivityUpdateCuriculumBinding

    private val viewmodel: UpdateCuriculumViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "extra_data"
        private const val DATE_PICKER_TAG_START = "DatePickerStart"
        private const val DATE_PICKER_TAG_END = "DatePickerEnd"
    }

    // variable untuk post
    private var idCompany: String? = ""
    private var idType: String? = ""
    private var idCompentency: String? = ""
    private var idLevel: String? = ""

    private var dataCuriculum: Curiculum? = null

    //spinner
    private val listSpinCompany = ArrayList<Company>()
    private val listSpinCompanyName = ArrayList<String>()
    private val listSpinCompetency = ArrayList<Competency>()
    private val listSpinCompetencyName = ArrayList<String>()
    private val listSpinType = ArrayList<Type>()
    private val listSpinTypeName = ArrayList<String>()
    private val listSpinProficiencyLevel = ArrayList<PL>()
    private val listSpinProficiencyLevelName = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCuriculumBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dataCuriculum = intent.getParcelableExtra(EXTRA_DATA)

        val begda = CurrentDate.getToday()
        val enda = CurrentDate.getToday()

        idCompany = dataCuriculum?.businessCode ?: ""
        idType = dataCuriculum?.requestTypeId
        idCompentency = dataCuriculum?.competenceId
        idLevel = dataCuriculum?.plCode


        setupObserver(begda, enda)
        setupExistingData(dataCuriculum)

        Timber.d(dataCuriculum?.requestTypeName)

        Timber.d("begda : $begda, enda : $enda")


        //onclick
        binding.tvDropdownCompany.setOnClickListener(this)
        binding.tvDropdownCompetency.setOnClickListener(this)
        binding.tvDropdownLevel.setOnClickListener(this)
        binding.tvDropdownType.setOnClickListener(this)
        binding.tvDropdownStartDate.setOnClickListener(this)
        binding.tvDropdownEndDate.setOnClickListener(this)
        binding.btnSave.onThrottledClick {
            collectData()
        }

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Update Curiculum"
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupExistingData(dataCuriculum: Curiculum?) {
        with(binding) {
            tvDropdownCompany.text =
                dataCuriculum?.companyName ?: getString(R.string.txt_pilih_perusahaan)
            edtCuriculumnRequestName.setText(dataCuriculum?.requestName)
            edtCuriculumnDeskripsi.setText(dataCuriculum?.requestDescription)
            tvDropdownType.text = dataCuriculum?.requestTypeName ?: getString(R.string.txt_type)
            tvDropdownCompetency.text =
                dataCuriculum?.competenceName ?: getString(R.string.txt_pilih_competency)
            tvDropdownLevel.text =
                dataCuriculum?.plName ?: getString(R.string.txt_proficiency_level)
            tvDropdownStartDate.text =
                dataCuriculum?.beginDate ?: getString(R.string.txt_pilih_tanggal)
            tvDropdownEndDate.text = dataCuriculum?.endDate ?: getString(R.string.txt_pilih_tanggal)
        }
    }

    private fun setupObserver(begda: String, enda: String) {

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
                    idCompany = listSpinCompany[i].companyId
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

        }
    }

    private fun collectData() {
        val startDate = binding.tvDropdownStartDate.text.toString()
        val endDate = binding.tvDropdownEndDate.text.toString()
        val requestName = binding.edtCuriculumnRequestName.text.toString()
        val desc = binding.edtCuriculumnDeskripsi.text.toString()

        val updateCuriculum = CuriculumUpdate(
            endDate = endDate,
            requestName = requestName,
            competence = idCompentency.toString(),
            objectIdentifier = dataCuriculum!!.objectIdentifier,
            requestType = idType.toString(),
            beginDate = startDate,
            businessCode = idCompany.toString(),
            requestDescription = desc,
            requestId = dataCuriculum!!.requestId,
            plCode = idLevel.toString()
        )

        submitUpdate(updateCuriculum)
    }

    private fun submitUpdate(updateCuriculum: CuriculumUpdate) {

        Timber.d("UpdateCuriculum : $updateCuriculum")
        viewmodel.updateCuriculum(updateCuriculum).observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        val message = data.message.toString()
                        Timber.d("messageUpdate $message")

                        val msg = "Update Success"
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        binding.progressBar.visibility = View.GONE

                        finish()

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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}