package edu.miu.restful.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private List<Post> posts;

    public User(long id, String name, List<Post> posts){
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
}
