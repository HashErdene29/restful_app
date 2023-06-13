package edu.miu.restful.repo;

import edu.miu.restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

//    public Post getPostsByUserId(int pId, int postId);
//    public List<User> findAllUserHasMultiplePosts();
    void deleteById(long id);
    @Modifying
    @Query("update User u set u.firstname = :firstname where u.id = :id")
    void updateAllById(@Param("id") long id, @Param("firstname") String firstname);
//    public List<User_p> findAllByPosts(long post_id);

//    @Modifying
//    @Query("select u.id, u.firstname from User u inner join Post p on u.id = p.user_p.id group by u.id having count(p.user_p.id) > :n")
//    List<User> findUsersByPostCount(int n);

    User findByEmail(String email);
}
