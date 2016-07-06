package com.example.dongminshin.samplekotlin.chapter.chapter1;

import org.junit.Test;

/**
 * Created by DongMinShin on 16. 7. 6..
 */
public class ArtistJavaTest {

    @Test
    public void artist_test() {
        ArtistJava artistJava = new ArtistJava();
        artistJava.setId(100);
        artistJava.setName("Shin");
        artistJava.setUrl("s145@naver.com");
        artistJava.setMbid("100_mbid");

        System.out.println(artistJava.toString());
    }

}