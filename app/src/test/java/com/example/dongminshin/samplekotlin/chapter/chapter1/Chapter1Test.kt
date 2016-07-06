package com.example.dongminshin.samplekotlin

import com.example.dongminshin.samplekotlin.chapter.chapter1.ArtistKotlin
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by DongMinShin on 16. 6. 22..
 */

class Chapter1Test {

    @Test
    fun chapter1_expresiveness_test() {
        val artist = ArtistKotlin();
        artist.id = 100;
        artist.name = "Shin"
        artist.url = "s145@naver.com"
        artist.mbid = "100_mbid";

        println(artist.print());
    }

    @Test
    fun chapter1_nullsafety_test() {
        // ? 키워드를 사용하지 않으면 null 할당 불가
//        var notNullArtist: ArtistKotlin = null

        // ? 키워드를 사용해야지만 비로소 null 할당 가능
        var artist: ArtistKotlin? = null;

        // null이 될 수 있는 가능성이 존재하기 때문에 null 체크 없이는 컴파일 불가
//        artist.print()

        // Solution 1
        if (artist != null) {
            artist.print()
        }

        // Solution 2
        println("Solution2 : ${artist?.print()}")

        // Solution 4
        val name = artist?.name ?: "empty"
        assertEquals(name, "empty")
    }

    @Test(expected = NullPointerException::class)
    fun chapter1_foreced_execute_not_null_safety_test() {
        // Solution 3
        var artist: ArtistKotlin? = null;
        artist!!.print()
    }

}