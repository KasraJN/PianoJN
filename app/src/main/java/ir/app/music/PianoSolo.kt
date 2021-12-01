package ir.app.music

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.chengtao.pianoview.entity.AutoPlayEntity
import com.chengtao.pianoview.entity.Piano.PianoKeyType
import com.chengtao.pianoview.entity.Piano.PianoVoice
import com.chengtao.pianoview.listener.OnLoadAudioListener
import com.chengtao.pianoview.listener.OnPianoAutoPlayListener
import com.chengtao.pianoview.listener.OnPianoListener
import com.chengtao.pianoview.utils.AutoPlayUtils
import com.chengtao.pianoview.view.PianoView
import java.io.IOException
import java.util.*

class PianoSolo : AppCompatActivity(), OnPianoListener, OnLoadAudioListener,
    OnSeekBarChangeListener, View.OnClickListener, OnPianoAutoPlayListener {

    private var pianoView: PianoView? = null
    private var seekBar: SeekBar? = null
    private var leftArrow: Button? = null
    private var rightArrow: Button? = null
    private var scrollProgress = 0

    private var isPlay = false
    private var litterStarList: ArrayList<AutoPlayEntity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.solo_piano)

        pianoView = findViewById(R.id.pv)
        pianoView!!.setSoundPollMaxStream(10)
        seekBar = findViewById(R.id.sb)
        seekBar!!.thumbOffset = convertDpToPixel(PianoSolo.Companion.SEEKBAR_OFFSET_SIZE).toInt()
        leftArrow = findViewById(R.id.iv_left_arrow)
        rightArrow = findViewById(R.id.iv_right_arrow)

        pianoView!!.setPianoListener(this)
        pianoView!!.setAutoPlayListener(this)
        pianoView!!.setLoadAudioListener(this)
        seekBar!!.setOnSeekBarChangeListener(this)
        rightArrow!!.setOnClickListener(this)
        leftArrow!!.setOnClickListener(this)

        if (PianoSolo.Companion.USE_CONFIG_FILE) {
            val assetManager = assets
            try {
                litterStarList = AutoPlayUtils.getAutoPlayEntityListByCustomConfigInputStream(
                    assetManager.open(PianoSolo.Companion.CONFIG_FILE_NAME)
                )
            } catch (e: IOException) {
                Log.e("TAG", e.message)
            }
        } else {
        }
    }

    override fun onPianoInitFinish() {}
    override fun onPianoClick(
        type: PianoKeyType, voice: PianoVoice, group: Int,
        positionOfGroup: Int
    ) {
    }

    override fun loadPianoAudioStart() {
    }

    override fun loadPianoAudioFinish() {
    }

    override fun loadPianoAudioError(e: Exception) {
    }

    override fun loadPianoAudioProgress(progress: Int) {
        Log.e("TAG", "progress:$progress")
    }

    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
        pianoView!!.scroll(i)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {}
    override fun onStopTrackingTouch(seekBar: SeekBar) {}
    override fun onResume() {

        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        super.onResume()
    }

    override fun onClick(view: View) {
        if (scrollProgress == 0) {
            try {
                scrollProgress = pianoView!!.layoutWidth * 100 / pianoView!!.pianoWidth
            } catch (e: Exception) {
            }
        }
        var progress: Int
        when (view.id) {
            R.id.iv_left_arrow -> {
                if (scrollProgress == 0) {
                    progress = 0
                } else {
                    progress = seekBar!!.progress - scrollProgress
                    if (progress < 0) {
                        progress = 0
                    }
                }
                seekBar!!.progress = progress
            }
            R.id.iv_right_arrow -> {
                if (scrollProgress == 0) {
                    progress = 100
                } else {
                    progress = seekBar!!.progress + scrollProgress
                    if (progress > 100) {
                        progress = 100
                    }
                }
                seekBar!!.progress = progress
            }
        }
    }

    private fun convertDpToPixel(dp: Float): Float {
        val resources = this.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    override fun onPianoAutoPlayStart() {
    }

    override fun onPianoAutoPlayEnd() {
        isPlay = false
    }

    override fun onDestroy() {
        super.onDestroy()
        if (pianoView != null) {
            pianoView!!.releaseAutoPlay()
        }
    }

    companion object {
        private const val CONFIG_FILE_NAME = "simple_little_star_config"
        private const val USE_CONFIG_FILE = true
        private const val SEEKBAR_OFFSET_SIZE = -12f
    }
}