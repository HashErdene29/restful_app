package edu.miu.restful.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "user_p")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user_p", cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

    public User(long id, String firstname, String lastname, String email, String password, List<Post> posts){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }
}
