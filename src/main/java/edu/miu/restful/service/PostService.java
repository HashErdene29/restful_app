package edu.miu.restful.service;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.ProductDto;

import java.util.List;

public interface PostService {
    List<PostDto>findAllByAuthor(String author);

}
