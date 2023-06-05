package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post>findAllByAuthor(String author);
}
