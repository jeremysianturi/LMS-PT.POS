package com.pos.lms.mobile.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pos.lms.core.data.Resource
import com.pos.lms.core.data.source.remote.response.account.ListAccountResponse
import com.pos.lms.core.utils.ErrorMessageSplit
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityHomeBinding
import com.pos.lms.mobile.helper.Debounce.onThrottledClick
import com.pos.lms.mobile.ui.changePassword.ChangePasswordActivity
import com.pos.lms.mobile.ui.login.LoginActivity
import com.pos.lms.mobile.ui.materi.MateriActivity
import com.pos.lms.mobile.ui.mentor.MentorActivity
import com.pos.lms.mobile.ui.profile.ProfileActivity
import com.pos.lms.mobile.ui.proposal.CuriculumActivity
import com.pos.lms.mobile.ui.roadmap.RoadmapActivity
import com.pos.lms.mobile.ui.student.StudentActivity
import com.pos.lms.mobile.ui.trainer.TrainerUserActivity
import com.pos.lms.mobile.util.ErrorLog
import com.pos.lms.mobile.util.diaolg.ErrorBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import kotlin.system.exitProcess


/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), View.OnClickListener {

//    private lateinit var binding: ActivityHomeBinding

    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private val viewModel: HomeViewModel by viewModels()
    private val binding: ActivityHomeBinding by viewBinding()

    //bottomSheet
    private var bottomSheetDialog: BottomSheetDialog? = null

    private var doubleBackToExitPressedOnce = false

    private var role: String? = ""
    private var reequestType: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()

        bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialog)

        binding.content.student.setOnClickListener(this)
        binding.content.roadMap.setOnClickListener(this)
        binding.content.learningProposal.setOnClickListener(this)
        binding.content.searchMateri.setOnClickListener(this)

        // method
//        setupObserver()
        appBarOnClick()
        setupRole()

        val time = System.currentTimeMillis()

        Timber.tag("HomeActivity").d("CurrentTimeMillis : $time")

//        val actionbar = supportActionBar
//        actionbar?.title = "Home"

    }

    private fun setupRole() {
        AndroidNetworking.get("https://pos-lms.digitalevent.id/ldap/api/auth/account")
            .addHeaders("Authorization", "Bearer ${mPreferenceEntity.token}")
            .build()
            .getAsObject(ListAccountResponse::class.java,
                object : ParsedRequestListener<ListAccountResponse> {
                    override fun onResponse(response: ListAccountResponse?) {
                        Timber.d("role : ${response?.accountResponse?.role}")
                        val roleList = response?.accountResponse?.role.toString().trim()

                        val items1 = roleList.split(",").toTypedArray()
                        val lastIndex = items1.size - 1
                        when (items1[lastIndex].trim()) {
                            "MENTOR]" -> {
                                Timber.d("masuk mentor")
                                reequestType = "MENID"
                                setupObserver(reequestType)
                                setupUI(reequestType)
                                setupOnClick(reequestType)
                            }
                            "TRAINER]" -> {
                                Timber.d("masuk trainer")
                                reequestType = "TRAID"
                                setupObserver(reequestType)
                                setupUI(reequestType)
                                setupOnClick(reequestType)
                            }
                            else -> {
                                Timber.d("masuk participant")
                                reequestType = "PARID"
                                setupObserver(reequestType)
                                setupUI(reequestType)
                                setupOnClick(reequestType)

                            }
                        }

                    }

                    override fun onError(anError: ANError?) {
                        ErrorLog.errorLog(
                            HomeActivity::class.java.simpleName,
                            anError,
                            "Account_role"
                        )
                    }
                })

    }

    private fun setupOnClick(reequestType: String) {
        when (reequestType) {
            "MENID" -> {
                binding.content.mentor.onThrottledClick {
                    val mIntent = Intent(this, MentorActivity::class.java)
                    startActivity(mIntent)
                }

            }
            "TRAID" -> {
                binding.content.mentor.onThrottledClick {
                    val mIntent = Intent(this, TrainerUserActivity::class.java)
                    startActivity(mIntent)
                }
            }
            else -> {
                binding.content.mentor.visibility = View.GONE
            }
        }

    }

    private fun setupUI(reequestType: String) {
        when (reequestType) {
            "MENID" -> {

            }
            "TRAID" -> {
                binding.content.txtMentor.text = "Expert"
                binding.content.txtData.text = "My Trainer Data"

            }
            else -> {
                binding.content.mentor.visibility = View.GONE
            }
        }
    }

    private fun appBarOnClick() {
        binding.topAppBar.title = "Infinite S"
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    val mIntent = Intent(this, ProfileActivity::class.java)
                    startActivity(mIntent)
                    true
                }
                R.id.logout -> {
                    popupConfirm()
                    true
                }
                R.id.changePassword -> {
                    val mIntent = Intent(this, ChangePasswordActivity::class.java)
                    startActivity(mIntent)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupObserver(reequestType: String) {
        val token = "${mPreferenceEntity.tokenType} ${mPreferenceEntity.token}"

        // SEMENTARA HARCODE DLU BLM ADA APINYA
        // jika 963388988 adalah mentor lainya participant
//        val typeId = if (mPreferenceEntity.username.equals("963388988")) "MENID" else "PARID"

        viewModel.getParId(reequestType).observe(this, { parid ->
            if (parid != null) {
                when (parid) {
                    is Resource.Loading -> binding.content.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        Timber.d("parIDHome : ${parid.data?.get(0)?.id}")
                        mPreferenceEntity.parId = parid.data?.get(0)?.id ?: 0
                        mPreference.setPref(mPreferenceEntity)
                        binding.content.progressBar.visibility = View.GONE
                    }
                    is Resource.Error -> {
                        binding.content.progressBar.visibility = View.GONE
                        Timber.tag("ERROR_PARID").e(parid.message)
                        val message = ErrorMessageSplit.message(parid.message.toString())
                        val code = ErrorMessageSplit.code(parid.message.toString())
                        ErrorBottomSheet.instance(code, message)
                            .show(supportFragmentManager, ErrorBottomSheet.TAG)
                    }

                }

            }

        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.student -> {
                val mIntent = Intent(this, StudentActivity::class.java)
                startActivity(mIntent)
            }
            R.id.roadMap -> {
                val mIntent = Intent(this, RoadmapActivity::class.java)
                startActivity(mIntent)
            }
            R.id.learningProposal -> {
                val mIntent = Intent(this, CuriculumActivity::class.java)
                startActivity(mIntent)
            }
            R.id.searchMateri -> {
                val mIntent = Intent(this, MateriActivity::class.java)
                startActivity(mIntent)
            }
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        return super.onCreateOptionsMenu(menu)
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_home, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        return if (id == R.id.action_profile) {
//            val mIntent = Intent(this, ProfileActivity::class.java)
//            startActivity(mIntent)
//            true
//        } else super.onOptionsItemSelected(item)
//    }

    private fun popupConfirm() {
        //init bottomSheet
        val views = layoutInflater.inflate(R.layout.bottom_sheet_confirmation, null)
        bottomSheetDialog?.setContentView(views)
        val tittle = views.findViewById<TextView>(R.id.tvDialogTittle)
        val content = views.findViewById<TextView>(R.id.tvDialogMessage)
        val btnNo = views.findViewById<Button>(R.id.btnDialogNo)
        val btnYes = views.findViewById<Button>(R.id.btnDialogYes)

        tittle.text = getString(R.string.txt_konfirmasi)
        content.text = getString(R.string.txt_logout_message)
        btnNo.text = getString(R.string.text_batal)
        btnYes.text = getString(R.string.txt_logout)
        bottomSheetDialog?.show()

        //onclick bottomsheet
        // positive button
        btnYes.setOnClickListener {
            logout()
            bottomSheetDialog?.dismiss()
        }
        // negative button
        btnNo.setOnClickListener {
            bottomSheetDialog?.dismiss()
        }

    }

    private fun logout() {
        mPreferenceEntity.isLogin = false
        mPreference.setPref(mPreferenceEntity)
        val mIntent = Intent(this, LoginActivity::class.java)
        startActivity(mIntent)
        finish()

    }


    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            exitProcess(0)
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Klik sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
//        Toasty.warning(this, "Klik sekali lagi untuk keluar", Toasty.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed(
            { doubleBackToExitPressedOnce = false },
            2000
        ) // review
    }


}

