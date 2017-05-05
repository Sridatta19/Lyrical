package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sridattap on 13/04/17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Document
@Data
@ToString
public class Lyric {

    @Id
    private String id;

    private String content;

    private int likes;

    private String songId;

    public Lyric(String songId, String content){
        this.content = content;
        this.songId = songId;
    }

    public void like(){
        ++this.likes;
    }
}
