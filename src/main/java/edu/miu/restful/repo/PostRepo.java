package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    void deleteById(long id);
    @Modifying
    @Query("UPDATE Post p set p.title = :title where p.id = :id")
    long updateTitleById(@Param("id") long id, @Param("title") String title);
    List<Post>findAllByAuthor(String author);
    List<Post>findAllByTitle(String title);
}
