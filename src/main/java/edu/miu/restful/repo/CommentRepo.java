package edu.miu.restful.repo;

import edu.miu.restful.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Modifying
    @Query("update Comment c set c.name = :name where c.id = :id")
    void updateNameById(@Param("id") long id, @Param("name") String name);
}
