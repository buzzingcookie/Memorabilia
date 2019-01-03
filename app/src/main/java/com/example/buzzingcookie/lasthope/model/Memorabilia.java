package com.example.buzzingcookie.lasthope.model;

public class Memorabilia {

    private static final String TAG = "Memorabilia";

    private String artist;
    private String band;
    private String title;
    private String genre;
    private int image;

    public Memorabilia(String artist, int image){
        this.artist = artist;
        this.image = image;
    }

}
