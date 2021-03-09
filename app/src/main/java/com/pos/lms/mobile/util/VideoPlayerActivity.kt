package com.pos.lms.mobile.util

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.pos.lms.core.domain.model.MateriSchedule
import com.pos.lms.core.utils.PreferenceEntity
import com.pos.lms.core.utils.UserPreference
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ActivityVideoPlayerBinding
import com.pos.lms.mobile.databinding.ContentVideoPlayerBinding
import timber.log.Timber

class VideoPlayerActivity : AppCompatActivity(), Player.EventListener {

    private val TAG = VideoPlayerActivity::class.java.simpleName

    companion object {
        const val EXTRA_DATA = "extra_data"
        private const val PDF_SELECTION_CODE = 99

    }

    private var flagFullScreen: Boolean = false

    private var binding: ActivityVideoPlayerBinding? = null

    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var playbackPosition: Long = 0

    private var mp4Url: String? = ""
    private lateinit var mPreference: UserPreference
    private lateinit var mPreferenceEntity: PreferenceEntity

    private var binding2: ContentVideoPlayerBinding? = null

    private val dataSourceFactory: DataSource.Factory by lazy {
        DefaultDataSourceFactory(this, "exoplayer-sample")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityVideoPlayerBinding.inflate(layoutInflater).also { binding = it }
        setContentView(binding!!.root)

        binding2 = ContentVideoPlayerBinding.inflate(layoutInflater)

        binding2!!.exoFullscreen.setOnClickListener {
            Toast.makeText(this, "full_screen_click", Toast.LENGTH_SHORT).show()
            Timber.tag(TAG).d("full_screen_click")
        }


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // video player
        mPreference = UserPreference(this)
        mPreferenceEntity = mPreference.getPref()


        val token = mPreferenceEntity.token.toString()

        val dataIntent = intent.getParcelableExtra<MateriSchedule>(EXTRA_DATA)

        val materiId = dataIntent?.materiTypeId ?: 0

        val videoUrl = dataIntent?.address

        mp4Url = videoUrl
        Timber.tag(TAG).d("urlVideo : $mp4Url")
        binding2 = ContentVideoPlayerBinding.inflate(layoutInflater)

        binding2?.apply {
            exoFullscreen.setOnClickListener {
                if (flagFullScreen) {
                    // set icon fullscreen enter
                    exoFullscreen.setImageDrawable(resources.getDrawable(R.drawable.exo_ic_fullscreen_enter))
                    // set orientation lanscape
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    Toast.makeText(this@VideoPlayerActivity, "Potrait", Toast.LENGTH_SHORT).show()
                    flagFullScreen = false
                } else {
                    // set icon fullscreen exit
                    exoFullscreen.setImageDrawable(resources.getDrawable(R.drawable.exo_ic_fullscreen_exit))
                    // set orientation lanscape
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    Toast.makeText(this@VideoPlayerActivity, "LANDSCAPE", Toast.LENGTH_SHORT).show()

                    flagFullScreen = true
                }
            }
        }

//        binding2.

        //setup Actionbar and navigasi up
        val actionbar = supportActionBar
        actionbar?.title = "Video Materi"
        actionbar?.setDisplayHomeAsUpEnabled(true)

    }


    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }


    private fun initializePlayer() {
        simpleExoplayer = SimpleExoPlayer.Builder(this).build()
//        val randomUrl = urlList.random()
        preparePlayer(mp4Url.toString(), "default")
        simpleExoplayer.also { binding?.exoplayerView?.player = it }
        simpleExoplayer.seekTo(playbackPosition)
        simpleExoplayer.playWhenReady = true
        simpleExoplayer.addListener(this)
    }

    private fun buildMediaSource(uri: Uri, type: String): MediaSource {
        return if (type == "dash") {
            DashMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        } else {
            ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        }
    }

    private fun preparePlayer(videoUrl: String, type: String) {
        val uri = Uri.parse(videoUrl)
        val mediaSource = buildMediaSource(uri, type)
        simpleExoplayer.prepare(mediaSource)
    }

    private fun releasePlayer() {
        playbackPosition = simpleExoplayer.currentPosition
        simpleExoplayer.release()
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        // handle error
        Toast.makeText(this, "Gagal memutar video, cba beberapa saat lagi", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (playbackState == Player.STATE_BUFFERING)
            binding?.progressBar?.visibility = View.VISIBLE
        else if (playbackState == Player.STATE_READY || playbackState == Player.STATE_ENDED)
            binding?.progressBar?.visibility = View.INVISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}