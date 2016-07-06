package com.example.dongminshin.samplekotlin.chapter.chapter1

/**
 * Created by DongMinShin on 16. 7. 6..
 */
class ArtistKotlin {

    var id: Long = 0
    var name: String? = null
    var url: String? = null
    var mbid: String? = null

    fun print(): String {
        return "Artist{id=$id, name='$name', url='$url', mbid='$mbid'}"
    }
}
