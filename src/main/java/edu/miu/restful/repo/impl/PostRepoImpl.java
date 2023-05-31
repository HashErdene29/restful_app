package edu.miu.restful.repo.impl;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Product;
import edu.miu.restful.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 3;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(1,"PostTitle1","PostContent1","PostAuthor1");
        Post p2 = new Post(2,"PostTitle2","PostContent2","PostAuthor2");
        posts.add(p1);
        posts.add(p2);
    }


    public List<Post> findAll(){
        return posts;
    }

    public void save(Post p) {
        p.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(p);
    }


    @Override
    public void delete(int id) {
        var product =posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(product);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Post>findAllAuthorByName(String author){
        return posts.stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
