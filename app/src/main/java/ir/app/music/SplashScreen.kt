package ir.app.music

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import me.wangyuwei.particleview.ParticleView
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier

class SplashScreen : AppCompatActivity() {

    lateinit var particleView: ParticleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        particleView = findViewById(R.id.pc)

        particleView.startAnim()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            finish()
        }, 5000)
    }
}