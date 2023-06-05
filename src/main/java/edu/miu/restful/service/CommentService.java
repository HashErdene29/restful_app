package edu.miu.restful.service;

import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    CommentDto getById(long id);

    void save(CommentDto p);

    void delete(long id);

    void update(long id, String name);
}
