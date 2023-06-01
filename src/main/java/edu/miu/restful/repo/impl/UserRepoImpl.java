package edu.miu.restful.repo.impl;

import edu.miu.restful.entity.User;
import edu.miu.restful.entity.Post;
import edu.miu.restful.repo.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepoImpl implements UserRepo {
    private static List<User> users;
    private static int userId = 103;
    static {
        users = new ArrayList<>();
        Post p1a = new Post(1,"PostTitle1","PostContent1","PostAuthor1");
//        Post p1b = new Post(2,"PostTitle2","PostContent2","PostAuthor2");
        List<Post> posts1 = Arrays.asList(p1a);

        Post p2a = new Post(3,"PostTitle3","PostContent3","PostAuthor3");
        Post p2b = new Post(4,"PostTitle4","PostContent4","PostAuthor4");
        List<Post> posts2 = Arrays.asList(p2a,p2b);

        User p1 = new User(101,"User1", posts1);
        User p2 = new User(102,"User2", posts2);
        users.add(p1);
        users.add(p2);
    }


    public List<User> findAll(){
        return users;
    }

    public void save(User p) {
        p.setId(userId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        userId++;
        users.add(p);
    }


    @Override
    public void delete(int id) {
        var user =users
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        users.remove(user);
    }

    @Override
    public void update(int id, User p) {
        User toUpdate = getById(id);
        toUpdate.setName(p.getName());
    }

    public User getById(int id) {
        return users
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Post getPostsByUserId(int pId, int postId){

        return getById(pId).getPosts().stream()
                .filter(l -> l.getId() == postId)
                .findFirst()
                .orElse(null);

        // =============Just to clarify what's going on ==========================
        //        var p = getById(pId);
        //        var review = p.getReviews().stream()
        //                .filter(l -> l.getId() == reviewId)
        //                .findFirst()
        //                .orElse(null);

    }

    @Override
    public List<User> findAllUserHasMultiplePosts(){
        return users.stream()
                .filter(p -> p.getPosts().stream().count() > 1)
                .collect(Collectors.toList());
    }
}
