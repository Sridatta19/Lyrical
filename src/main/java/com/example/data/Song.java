package com.example.data;

import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by sridattap on 13/04/17.
 */
public class Song {

    private ObjectId id;

    private String title;

    private List<Lyric> lyrics;
}
