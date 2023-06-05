package edu.miu.restful.service;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.ProductDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    PostDto getById(long id);

    void save(PostDto p);

    void delete(long id);

    void update(long id, String title);
    List<PostDto>findAllByAuthor(String author);
    List<PostDto>findAllByTitle(String title);
}
