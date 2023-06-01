package edu.miu.restful.service.impl;

import edu.miu.restful.entity.User;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.entity.dto.UserDetailDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<UserDto> findAll() {
        return (List<UserDto>) listMapper.mapList(userRepo.findAll(),new UserDto());}


    public UserDto getById(int id) {
        return modelMapper.map(userRepo.getById(id), UserDto.class);
    }

    @Override
    public UserDetailDto getPostsByUserId(int id) {
        if(id == 0)
            return new UserDetailDto();
        return modelMapper.map(userRepo.getById(id), UserDetailDto.class);
    }

    @Override
    public void save(UserDto p) {
        userRepo.save(modelMapper.map(p, User.class));
    }

    @Override
    public void delete(int id) {
        userRepo.delete(id);
    }

    @Override
    public void update(int id,  UserDto p) {
        userRepo.update(id, modelMapper.map(p, User.class));
    }

    @Override
    public Post getPostsByUserId(int uId, int postId){
        return userRepo.getPostsByUserId(uId, postId);
    }

    @Override
    public List<UserDto> findAllUserHasMultiplePosts(){
        return (List<UserDto>) listMapper.mapList(userRepo.findAllUserHasMultiplePosts(),new UserDto());
    }
}
