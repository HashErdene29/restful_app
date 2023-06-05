package edu.miu.restful.repo;

import edu.miu.restful.entity.User_p;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User_p, Long> {

//    public Post getPostsByUserId(int pId, int postId);
//    public List<User> findAllUserHasMultiplePosts();
}
