package edu.miu.restful.repo;

import edu.miu.restful.entity.User;
import edu.miu.restful.entity.Post;

import java.util.List;

public interface UserRepo {
    public List<User> findAll();

    public User getById(int id);

    public void save(User p);

    public void delete(int id);

    public void update(int id, User p);


    public Post getPostsByUserId(int pId, int postId);

    public List<User> findAllUserHasMultiplePosts();
}
