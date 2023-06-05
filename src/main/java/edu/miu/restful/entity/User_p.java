package edu.miu.restful.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User_p {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "user_p", cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    private List<Post> posts;

    public User_p(long id, String name, List<Post> posts){
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
}
