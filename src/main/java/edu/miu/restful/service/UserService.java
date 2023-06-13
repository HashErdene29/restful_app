package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.UserDetailDto;
import edu.miu.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    UserDto getById(long id);

    void save(UserDto p);

    void delete(long id);

    void update(long id, String name);

//    List<UserDto> findAllByPosts(long post_id);
//    List<UserDto> findUsersByPostCount(int n);


}
