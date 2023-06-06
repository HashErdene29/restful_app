package edu.miu.restful.service.impl;

import edu.miu.restful.entity.User_p;
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


    public UserDto getById(long id) {
        return modelMapper.map(userRepo.getById(id), UserDto.class);
    }

    @Override
    public void save(UserDto p) {
        userRepo.save(modelMapper.map(p, User_p.class));
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(long id, String name) {
        userRepo.updateAllById(id, name);
    }

//    @Override
//    public List<UserDto> findAllByPosts(long post_id){
//        return (List<UserDto>) listMapper.mapList(userRepo.findAllByPosts(post_id),new UserDto());
//    }

    @Override
    public List<UserDto> findUsersByPostCount(int n){
        return (List<UserDto>) listMapper.mapList(userRepo.findUsersByPostCount(n),new UserDto());
    }
}
