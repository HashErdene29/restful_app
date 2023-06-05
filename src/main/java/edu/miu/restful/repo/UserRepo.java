package edu.miu.restful.repo;

import edu.miu.restful.entity.User_p;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User_p, Long> {

//    public Post getPostsByUserId(int pId, int postId);
//    public List<User> findAllUserHasMultiplePosts();
    void deleteById(long id);
    @Modifying
    @Query("update User_p u set u.name = :name where u.id = :id")
    void updateAllById(@Param("id") long id, @Param("name") String name);
    public List<User_p> findAllByPosts(long post_id);
}
