package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sridattap on 13/04/17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Document
@Data
@ToString
public class Song {

    @Id
    private String id;

    private String title;

    private List<Lyric> lyrics = new ArrayList<>();

    public Song(String songTitle){
        this.title = songTitle;
    }

    public Song addLyric(Lyric lyric){
        this.lyrics.add(lyric);
        return this;
    }
}
