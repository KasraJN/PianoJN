package ir.app.music

import android.app.PendingIntent.getActivity
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView

    lateinit var text: TextView

    private val MusicList = ArrayList<ModelMusic>()

    private lateinit var adaptermusic : AdapterMusic

    private var ints : String = "0"

    private var name : String = "Solo Piano"

    private var artist : String = "PianoJN"

    private var image : String = "https://d3kle7qwymxpcy.cloudfront.net/images/broadcasts/61/3c/35202/c175.png"

    private var ints1 : String = "1"

    private var name_one : String = "Jane Maryam"

    private var artist_one : String = "Mohammad Nouri"

    private var image_one : String = "https://img9.irna.ir/d/r2/2020/07/30/4/157266439.jpg"

    private var ints3 : String = "3"

    private var name_three : String = "Pirates of the Caribbean"

    private var artist_three : String = "PianoJN"

    private var image_three : String = "https://www.giantfreakinrobot.com/wp-content/uploads/2020/11/Pirates-of-the-Caribbean-6-Johnny-Depp-%E2%80%98UNLIKELY-to-return-as-Captain-Jack-Sparrow-lailasnews-1280x720-1.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.rec_view)

        text = findViewById(R.id.text_name_app)

        val tp = Typeface.createFromAsset(assets, "font/music.ttf")
        text.typeface = tp

        val list = ModelMusic(
            this,
            ints,
            name,
            artist,
            image,
            ints1,
            name_one,
            artist_one,
            image_one,
            ints3,
            name_three,
            artist_three,
            image_three
        )

        MusicList.add(list)

        adaptermusic = AdapterMusic(MusicList)
        adaptermusic.notifyDataSetChanged()

        recycler.adapter = adaptermusic
        recycler.layoutManager = LinearLayoutManager(applicationContext)
    }
}