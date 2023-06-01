package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.UserDetailDto;
import edu.miu.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    UserDto getById(int id);

    UserDetailDto getPostsByUserId(int id);

    void save(UserDto p);

    void delete(int id);

    void update(int id, UserDto p);

    Post getPostsByUserId(int pId, int reviewId);

    List<UserDto> findAllUserHasMultiplePosts();

}
