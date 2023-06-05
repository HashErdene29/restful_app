package edu.miu.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    private User_p user_p;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    public Post(long id, String title, String content, String author){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
