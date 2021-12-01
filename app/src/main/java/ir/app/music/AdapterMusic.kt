package ir.app.music

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

internal class AdapterMusic(private var MusicList: List<ModelMusic>) :
    RecyclerView.Adapter<AdapterMusic.MyViewHolder>() {

    private var mContext: Context? = null

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var card_one : CardView = view.findViewById(R.id.card_music_one)
        var text_name_one : TextView = view.findViewById(R.id.text_name_one)
        var text_artist_one : TextView = view.findViewById(R.id.text_artist_one)
        var img_music_one : ImageView = view.findViewById(R.id.img_music_one)

        var card_three : CardView = view.findViewById(R.id.card_music_three)
        var text_name_three : TextView = view.findViewById(R.id.text_name_three)
        var text_artist_three : TextView = view.findViewById(R.id.text_artist_three)
        var img_music_three : ImageView = view.findViewById(R.id.img_music_three)

        var card : CardView = view.findViewById(R.id.card_music)
        var text_name : TextView = view.findViewById(R.id.text_name)
        var text_artist : TextView = view.findViewById(R.id.text_artist)
        var img_music : ImageView = view.findViewById(R.id.img_music)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_list, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("ApplySharedPref")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = MusicList[position]

        mContext = list.getContext()

        val tp = Typeface.createFromAsset(mContext!!.assets, "font/music.ttf")

        holder.text_name_one.typeface = tp
        holder.text_artist_one.typeface = tp

        holder.text_name_three.typeface = tp
        holder.text_artist_three.typeface = tp

        holder.text_name.typeface = tp
        holder.text_artist.typeface = tp

        if (list.getInts() == "0"){
            Picasso.with(list.getContext()).load(list.getImage()).into(holder.img_music);
            holder.text_name.text = list.getName()
            holder.text_artist.text = list.getArtist()
        }

        if (list.getInts1() == "1"){
            Picasso.with(list.getContext()).load(list.getImage_one()).into(holder.img_music_one);
            holder.text_name_one.text = list.getName_one()
            holder.text_artist_one.text = list.getArtist_one()
        }

        if (list.getInts3() == "3"){
            Picasso.with(list.getContext()).load(list.getImage_three()).into(holder.img_music_three);
            holder.text_name_three.text = list.getName_three()
            holder.text_artist_three.text = list.getArtist_three()
        }

        holder.card_one.setOnClickListener(){

                val name: String = holder.text_name_one.text as String

                val sp: SharedPreferences = list.getContext()!!.getSharedPreferences("s", 0)
                val ed: Editor = sp.edit()
                ed.putString("name", name)
                ed.commit()

                val intent = Intent(mContext, Piano::class.java)
                list.getContext()!!.startActivity(intent)
            }

        holder.card_three.setOnClickListener(){

            val name : String = holder.text_name_three.text as String

            val sp : SharedPreferences = list.getContext()!!.getSharedPreferences("s", 0)
            val ed: Editor = sp.edit()
            ed.putString("name", name)
            ed.commit()

            val intent = Intent(mContext, Piano::class.java)
            list.getContext()!!.startActivity(intent)
        }

        holder.card.setOnClickListener(){

            val intent = Intent(mContext, PianoSolo::class.java)
            list.getContext()!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return MusicList.size
    }
}