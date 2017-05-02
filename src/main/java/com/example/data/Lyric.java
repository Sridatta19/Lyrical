package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
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

    private ObjectId id;

    private String content;

    private int likes;
}
