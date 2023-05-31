package edu.miu.restful.service;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.ProductDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    PostDto getById(int id);

    void save(PostDto p);

    void delete(int id);

    void update(int id, PostDto p);
    List<PostDto>findAllAuthorByName(String author);

}
