package ir.app.music

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.chengtao.pianoview.entity.Piano.PianoKeyType
import com.chengtao.pianoview.entity.Piano.PianoVoice
import com.chengtao.pianoview.listener.OnPianoListener
import com.chengtao.pianoview.view.PianoView
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Piano : AppCompatActivity(), OnPianoListener, View.OnClickListener {

    private var pianoView: PianoView? = null
    private var seekBar: SeekBar? = null
    private var leftArrow: Button? = null
    private var btnMusic: Button? = null
    private var play: Button? = null
    var layout: RelativeLayout? = null
    private var scrollProgress = 0

    var handler: Handler? = null

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.piano_activity)

        layout = findViewById(R.id.layout_note)

        pianoView = findViewById(R.id.pv)
        pianoView!!.setSoundPollMaxStream(10)
        seekBar = findViewById(R.id.sb)
        play = findViewById(R.id.play)
        seekBar!!.thumbOffset = convertDpToPixel(Piano.Companion.SEEKBAR_OFFSET_SIZE).toInt()

        leftArrow = findViewById(R.id.back)
        btnMusic = findViewById(R.id.refresh)

        btnMusic!!.setOnClickListener() {
            val intent = Intent(this@Piano, Piano::class.java)
            startActivity(intent)
            finish()
        }

        play!!.setOnClickListener() {

            play!!.visibility = View.GONE

            val sp : SharedPreferences = applicationContext.getSharedPreferences("s", 0)
            val message : String? = sp.getString("name", null)

            if (message == "Jane Maryam"){

                seekBar!!.post(Runnable {
                    if (seekBar != null) {
                        pianoView!!.scroll(60)
                    }
                })

                handler = Handler()

                val thread: Thread = Thread {
                    try {
                        Thread.sleep(600)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 1100

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread.start()

                val thread1: Thread = Thread {
                    try {
                        Thread.sleep(1200)
                        handler!!.post(Runnable {

                            val params2 = RelativeLayout.LayoutParams(250, 240)
                            params2.setMargins(900, 0, 0, 0)

                            val view2 = TextView(this@Piano)
                            view2.text = "B4"
                            view2.setTextColor(Color.GREEN)
                            view2.gravity = Gravity.CENTER
                            view2.setBackgroundResource(R.drawable.shape_note_white)
                            view2.layoutParams = params2

                            view2.animate().translationY((550).toFloat());
                            view2.animate().duration = 1100

                            layout!!.addView(view2)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread1.start()

                val thread2: Thread = Thread {
                    try {
                        Thread.sleep(2000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)

                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread2.start()

                val thread3: Thread = Thread {
                    try {
                        Thread.sleep(2700)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1250, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread3.start()

                val thread4: Thread = Thread {
                    try {
                        Thread.sleep(3300)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, -10, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread4.start()

                val thread5: Thread = Thread {
                    try {
                        Thread.sleep(3800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, -5, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread5.start()

                val thread6: Thread = Thread {
                    try {
                        Thread.sleep(4100)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, -3, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread6.start()

                val thread7: Thread = Thread {
                    try {
                        Thread.sleep(4700)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread7.start()

                val thread8: Thread = Thread {
                    try {
                        Thread.sleep(5400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, -3, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread8.start()

                val thread9: Thread = Thread {
                    try {
                        Thread.sleep(5900)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread9.start()

                val thread10: Thread = Thread {
                    try {
                        Thread.sleep(6410)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread10.start()

                val thread11: Thread = Thread {
                    try {
                        Thread.sleep(7100)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread11.start()

                val thread12: Thread = Thread {
                    try {
                        Thread.sleep(7700)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread12.start()

                val thread13: Thread = Thread {
                    try {
                        Thread.sleep(8300)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread13.start()

                val thread14: Thread = Thread {
                    try {
                        Thread.sleep(8600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread14.start()

                val thread15: Thread = Thread {
                    try {
                        Thread.sleep(9200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1500, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "F5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread15.start()

                val thread16: Thread = Thread {
                    try {
                        Thread.sleep(9800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread16.start()

                val thread17: Thread = Thread {
                    try {
                        Thread.sleep(10400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread17.start()

                val thread18: Thread = Thread {
                    try {
                        Thread.sleep(11000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread18.start()

                val thread20: Thread = Thread {
                    try {
                        Thread.sleep(11600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread20.start()

                val thread21: Thread = Thread {
                    try {
                        Thread.sleep(12200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread21.start()

                val thread22: Thread = Thread {
                    try {
                        Thread.sleep(12800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread22.start()

                val thread23: Thread = Thread {
                    try {
                        Thread.sleep(13400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread23.start()

                val thread24: Thread = Thread {
                    try {
                        Thread.sleep(14000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread24.start()

                val thread25: Thread = Thread {
                    try {
                        Thread.sleep(14600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread25.start()

                val thread26: Thread = Thread {
                    try {
                        Thread.sleep(15200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread26.start()

                val thread27: Thread = Thread {
                    try {
                        Thread.sleep(15800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread27.start()

                val thread28: Thread = Thread {
                    try {
                        Thread.sleep(16400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread28.start()

                val thread29: Thread = Thread {
                    try {
                        Thread.sleep(17600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread29.start()

                val thread30: Thread = Thread {
                    try {
                        Thread.sleep(18200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread30.start()

                val thread31: Thread = Thread {
                    try {
                        Thread.sleep(18800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread31.start()

                val thread32: Thread = Thread {
                    try {
                        Thread.sleep(19400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread32.start()

                val thread33: Thread = Thread {
                    try {
                        Thread.sleep(20000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread33.start()

                val thread34: Thread = Thread {
                    try {
                        Thread.sleep(20600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread34.start()

                val thread35: Thread = Thread {
                    try {
                        Thread.sleep(21200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread35.start()

                val thread36: Thread = Thread {
                    try {
                        Thread.sleep(21800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread36.start()

                val thread3o: Thread = Thread {
                    try {
                        Thread.sleep(22400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread3o.start()

                val thread37: Thread = Thread {
                    try {
                        Thread.sleep(22800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(600, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread37.start()

                val thread38: Thread = Thread {
                    try {
                        Thread.sleep(23400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread38.start()

                val thread39: Thread = Thread {
                    try {
                        Thread.sleep(24000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread39.start()

                val thread40: Thread = Thread {
                    try {
                        Thread.sleep(24600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread40.start()

                val thread41: Thread = Thread {
                    try {
                        Thread.sleep(25200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread41.start()

                val thread42: Thread = Thread {
                    try {
                        Thread.sleep(25800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread42.start()

                val thread43: Thread = Thread {
                    try {
                        Thread.sleep(26400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread43.start()

                val thread44: Thread = Thread {
                    try {
                        Thread.sleep(27000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(600, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread44.start()

                val thread45: Thread = Thread {
                    try {
                        Thread.sleep(27600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread45.start()

                val thread46: Thread = Thread {
                    try {
                        Thread.sleep(28200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread46.start()

                val thread47: Thread = Thread {
                    try {
                        Thread.sleep(28800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread47.start()

                val thread48: Thread = Thread {
                    try {
                        Thread.sleep(29400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread48.start()

                val thread49: Thread = Thread {
                    try {
                        Thread.sleep(30000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread49.start()

                val thread50: Thread = Thread {
                    try {
                        Thread.sleep(30600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread50.start()

                val thread51: Thread = Thread {
                    try {
                        Thread.sleep(31200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread51.start()

                val thread52: Thread = Thread {
                    try {
                        Thread.sleep(31800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1500, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "F5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread52.start()

                val thread53: Thread = Thread {
                    try {
                        Thread.sleep(32400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread53.start()

                val thread54: Thread = Thread {
                    try {
                        Thread.sleep(33000)
                        handler!!.post(Runnable {
                            //view

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1860, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread54.start()

                val thread55: Thread = Thread {
                    try {
                        Thread.sleep(33600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread55.start()

                val thread56: Thread = Thread {
                    try {
                        Thread.sleep(34200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1860, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread56.start()

                val thread57: Thread = Thread {
                    try {
                        Thread.sleep(34800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread57.start()

                val thread58: Thread = Thread {
                    try {
                        Thread.sleep(35400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1860, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread58.start()

                val thread59: Thread = Thread {
                    try {
                        Thread.sleep(36000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1700, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "G5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread59.start()

                val thread60: Thread = Thread {
                    try {
                        Thread.sleep(36600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1500, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "F5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread60.start()

                val thread61: Thread = Thread {
                    try {
                        Thread.sleep(37200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1500, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "F5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread61.start()

                val thread62: Thread = Thread {
                    try {
                        Thread.sleep(37800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread62.start()

                val thread63: Thread = Thread {
                    try {
                        Thread.sleep(38400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread63.start()

                val thread64: Thread = Thread {
                    try {
                        Thread.sleep(39000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread64.start()

                val thread65: Thread = Thread {
                    try {
                        Thread.sleep(39600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread65.start()

                val thread66: Thread = Thread {
                    try {
                        Thread.sleep(40200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread66.start()

                val thread67: Thread = Thread {
                    try {
                        Thread.sleep(40800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread67.start()

                val thread68: Thread = Thread {
                    try {
                        Thread.sleep(41400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread68.start()

                val thread69: Thread = Thread {
                    try {
                        Thread.sleep(42000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1500, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "F5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread69.start()

                val thread70: Thread = Thread {
                    try {
                        Thread.sleep(42600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread70.start()

                val thread71: Thread = Thread {
                    try {
                        Thread.sleep(43200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread71.start()

                val thread73: Thread = Thread {
                    try {
                        Thread.sleep(43800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread73.start()

                val thread74: Thread = Thread {
                    try {
                        Thread.sleep(44400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread74.start()

                val thread75: Thread = Thread {
                    try {
                        Thread.sleep(45000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(710, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "A4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread75.start()

                val thread76: Thread = Thread {
                    try {
                        Thread.sleep(45600)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(900, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "B4"
                            view3.setTextColor(Color.GREEN)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread76.start()

                val thread77: Thread = Thread {
                    try {
                        Thread.sleep(46200)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread77.start()

                val thread78: Thread = Thread {
                    try {
                        Thread.sleep(46800)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1300, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "D5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread78.start()

                val thread79: Thread = Thread {
                    try {
                        Thread.sleep(47400)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 240)
                            params3.setMargins(1400, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "E5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread79.start()

                val thread80: Thread = Thread {
                    try {
                        Thread.sleep(48000)
                        handler!!.post(Runnable {

                            val params3 = RelativeLayout.LayoutParams(250, 280)
                            params3.setMargins(1030, 0, 0, 0)

                            val view3 = TextView(this@Piano)
                            view3.text = "C5"
                            view3.setTextColor(Color.BLUE)
                            view3.gravity = Gravity.CENTER
                            view3.setBackgroundResource(R.drawable.shape_note_white)
                            view3.layoutParams = params3

                            view3.animate().translationY((550).toFloat());
                            view3.animate().duration = 1100

                            layout!!.addView(view3)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread80.start()
            }

            if (message == "Pirates of the Caribbean"){

                seekBar!!.post(Runnable {
                    if (seekBar != null) {
                        pianoView!!.scroll(50)
                    }
                })

                handler = Handler()

                val thread: Thread = Thread {
                    try {
                        Thread.sleep(400)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread.start()

                val thread1: Thread = Thread {
                    try {
                        Thread.sleep(800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread1.start()

                val thread2: Thread = Thread {
                    try {
                        Thread.sleep(1200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread2.start()

                val thread3: Thread = Thread {
                    try {
                        Thread.sleep(1800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread3.start()

                val thread4: Thread = Thread {
                    try {
                        Thread.sleep(2200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread4.start()

                val thread5: Thread = Thread {
                    try {
                        Thread.sleep(2800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread5.start()

                val thread6: Thread = Thread {
                    try {
                        Thread.sleep(3200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread6.start()

                val thread7: Thread = Thread {
                    try {
                        Thread.sleep(3800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread7.start()

                val thread8: Thread = Thread {
                    try {
                        Thread.sleep(4200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread8.start()

                val thread9: Thread = Thread {
                    try {
                        Thread.sleep(4800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread9.start()

                val thread10: Thread = Thread {
                    try {
                        Thread.sleep(5200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread10.start()

                val thread11: Thread = Thread {
                    try {
                        Thread.sleep(5800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread11.start()

                val thread12: Thread = Thread {
                    try {
                        Thread.sleep(6200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread12.start()

                val thread13: Thread = Thread {
                    try {
                        Thread.sleep(6800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread13.start()

                val thread14: Thread = Thread {
                    try {
                        Thread.sleep(7200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread14.start()

                val thread15: Thread = Thread {
                    try {
                        Thread.sleep(7800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(210, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A3"
                            view.setTextColor(Color.YELLOW)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread15.start()

                val thread16: Thread = Thread {
                    try {
                        Thread.sleep(8200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread16.start()

                val thread17: Thread = Thread {
                    try {
                        Thread.sleep(8800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread17.start()

                val thread18: Thread = Thread {
                    try {
                        Thread.sleep(9200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread18.start()

                val thread19: Thread = Thread {
                    try {
                        Thread.sleep(9800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread19.start()

                val thread20: Thread = Thread {
                    try {
                        Thread.sleep(10200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread20.start()

                val thread21: Thread = Thread {
                    try {
                        Thread.sleep(10800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread21.start()

                val thread22: Thread = Thread {
                    try {
                        Thread.sleep(11200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread22.start()

                val thread23: Thread = Thread {
                    try {
                        Thread.sleep(11800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread23.start()

                val thread24: Thread = Thread {
                    try {
                        Thread.sleep(12200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread24.start()

                val thread25: Thread = Thread {
                    try {
                        Thread.sleep(12800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread25.start()

                val thread26: Thread = Thread {
                    try {
                        Thread.sleep(13200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread26.start()

                val thread27: Thread = Thread {
                    try {
                        Thread.sleep(13800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread27.start()

                val thread28: Thread = Thread {
                    try {
                        Thread.sleep(14200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread28.start()

                val thread29: Thread = Thread {
                    try {
                        Thread.sleep(14800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread29.start()

                val thread30: Thread = Thread {
                    try {
                        Thread.sleep(15200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread30.start()

                val thread31: Thread = Thread {
                    try {
                        Thread.sleep(15800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(210, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A3"
                            view.setTextColor(Color.YELLOW)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread31.start()

                val thread32: Thread = Thread {
                    try {
                        Thread.sleep(16200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread32.start()

                val thread33: Thread = Thread {
                    try {
                        Thread.sleep(16800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread33.start()

                val thread34: Thread = Thread {
                    try {
                        Thread.sleep(17200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread34.start()

                val thread35: Thread = Thread {
                    try {
                        Thread.sleep(17800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread35.start()

                val thread36: Thread = Thread {
                    try {
                        Thread.sleep(18200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread36.start()

                val thread37: Thread = Thread {
                    try {
                        Thread.sleep(18800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread37.start()

                val thread38: Thread = Thread {
                    try {
                        Thread.sleep(19200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread38.start()

                val thread39: Thread = Thread {
                    try {
                        Thread.sleep(19800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread39.start()

                val thread40: Thread = Thread {
                    try {
                        Thread.sleep(20200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread40.start()

                val thread41: Thread = Thread {
                    try {
                        Thread.sleep(20800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread41.start()

                val thread42: Thread = Thread {
                    try {
                        Thread.sleep(21200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread42.start()

                val thread43: Thread = Thread {
                    try {
                        Thread.sleep(21800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread43.start()

                val thread44: Thread = Thread {
                    try {
                        Thread.sleep(22200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread44.start()

                val thread45: Thread = Thread {
                    try {
                        Thread.sleep(22800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread45.start()

                val thread46: Thread = Thread {
                    try {
                        Thread.sleep(23200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(210, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A3"
                            view.setTextColor(Color.YELLOW)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread46.start()

                val thread47: Thread = Thread {
                    try {
                        Thread.sleep(23800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread47.start()

                val thread48: Thread = Thread {
                    try {
                        Thread.sleep(24200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(510, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "C4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread48.start()

                val thread49: Thread = Thread {
                    try {
                        Thread.sleep(24800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread49.start()

                val thread50: Thread = Thread {
                    try {
                        Thread.sleep(25200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread50.start()

                val thread51: Thread = Thread {
                    try {
                        Thread.sleep(25800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread51.start()

                val thread52: Thread = Thread {
                    try {
                        Thread.sleep(26200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread52.start()

                val thread53: Thread = Thread {
                    try {
                        Thread.sleep(26800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread53.start()

                val thread54: Thread = Thread {
                    try {
                        Thread.sleep(27200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread54.start()

                val thread55: Thread = Thread {
                    try {
                        Thread.sleep(27800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread55.start()

                val thread56: Thread = Thread {
                    try {
                        Thread.sleep(28200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1360, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread56.start()

                val thread57: Thread = Thread {
                    try {
                        Thread.sleep(28800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(230, 240)
                            params.setMargins(1366, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_black)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread57.start()

                val thread58: Thread = Thread {
                    try {
                        Thread.sleep(29200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(230, 240)
                            params.setMargins(1366, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_black)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread58.start()

                val thread59: Thread = Thread {
                    try {
                        Thread.sleep(29800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(230, 240)
                            params.setMargins(1366, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_black)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread59.start()

                val thread60: Thread = Thread {
                    try {
                        Thread.sleep(30200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1360, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread60.start()

                val thread61: Thread = Thread {
                    try {
                        Thread.sleep(30800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread61.start()

                val thread62: Thread = Thread {
                    try {
                        Thread.sleep(31200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1360, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "A4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread62.start()

                val thread63: Thread = Thread {
                    try {
                        Thread.sleep(31800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread63.start()

                val thread64: Thread = Thread {
                    try {
                        Thread.sleep(32200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(710, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "D4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread64.start()

                val thread65: Thread = Thread {
                    try {
                        Thread.sleep(32800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread65.start()

                val thread66: Thread = Thread {
                    try {
                        Thread.sleep(33200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(910, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "E4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread66.start()

                val thread67: Thread = Thread {
                    try {
                        Thread.sleep(33800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread67.start()

                val thread68: Thread = Thread {
                    try {
                        Thread.sleep(34200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread68.start()

                val thread69: Thread = Thread {
                    try {
                        Thread.sleep(34800)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1040, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "F4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread69.start()

                val thread70: Thread = Thread {
                    try {
                        Thread.sleep(35200)
                        handler!!.post(Runnable {

                            val params = RelativeLayout.LayoutParams(250, 240)
                            params.setMargins(1160, 0, 0, 0)

                            val view = TextView(this@Piano)
                            view.text = "G4"
                            view.setTextColor(Color.GREEN)
                            view.gravity = Gravity.CENTER
                            view.setBackgroundResource(R.drawable.shape_note_white)
                            view.layoutParams = params

                            view.animate().translationY((550).toFloat());
                            view.animate().duration = 900

                            layout!!.addView(view)
                        })
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                thread70.start()
            }
        }

        pianoView!!.setPianoListener(this)
        leftArrow!!.setOnClickListener(this)
    }

    override fun onPianoInitFinish() {}
    override fun onPianoClick(
        type: PianoKeyType, voice: PianoVoice, group: Int,
        positionOfGroup: Int
    ) {
    }

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
        when (view.id) {
            R.id.back -> {
                val intent = Intent(this@Piano, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun convertDpToPixel(dp: Float): Float {
        val resources = this.resources
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    companion object {
        private const val SEEKBAR_OFFSET_SIZE = -12f
    }
}