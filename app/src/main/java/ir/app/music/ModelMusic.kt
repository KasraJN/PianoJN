package ir.app.music

import android.content.Context

class ModelMusic(context: Context?, ints: String?, name: String?, artist: String?, image: String?, ints1: String?, name_one: String?, artist_one: String?, image_one: String?, ints3: String?, name_three: String?, artist_three: String?, image_three: String?) {

    private var Context: Context

    private var Name: String
    private var Artist: String
    private var Image: String

    private var Ints: String
    private var Ints1: String
    private var Ints3: String

    private var Name_one: String
    private var Artist_one: String
    private var Image_one: String

    private var Name_three: String
    private var Artist_three: String
    private var Image_three: String

    init {

        this.Context = context!!

        this.Name = name!!
        this.Artist = artist!!
        this.Image = image!!

        this.Ints = ints!!
        this.Ints1 = ints1!!
        this.Ints3 = ints3!!

        this.Name_one = name_one!!
        this.Artist_one = artist_one!!
        this.Image_one = image_one!!

        this.Name_three = name_three!!
        this.Artist_three = artist_three!!
        this.Image_three = image_three!!
    }

    fun getContext(): Context? {
        return Context
    }

    fun getName(): String? {
        return Name
    }
    fun getArtist(): String? {
        return Artist
    }
    fun getImage(): String? {
        return Image
    }

    fun getName_one(): String? {
        return Name_one
    }
    fun getArtist_one(): String? {
        return Artist_one
    }
    fun getImage_one(): String? {
        return Image_one
    }

    fun getName_three(): String? {
        return Name_three
    }
    fun getArtist_three(): String? {
        return Artist_three
    }
    fun getImage_three(): String? {
        return Image_three
    }

    fun getInts(): String? {
        return Ints
    }
    fun getInts1(): String? {
        return Ints1
    }
    fun getInts3(): String? {
        return Ints3
    }
}