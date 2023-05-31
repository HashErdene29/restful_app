package edu.miu.restful.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostV2 {
    private long id;
    private String title;
    private String content;
    private String author;
    public PostV2(long id, String title, String content, String author){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
