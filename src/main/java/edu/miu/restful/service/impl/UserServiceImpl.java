package edu.miu.restful.service.impl;

import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;


//    @Override
//    public UserDetailDto getPostsByUserId(int id) {
//        if(id == 0)
//            return new UserDetailDto();
//        return modelMapper.map(userRepo.getById(id), UserDetailDto.class);
//    }

//    @Override
//    public List<UserDto> findAllUserHasMultiplePosts(){
//        return (List<UserDto>) listMapper.mapList(userRepo.findAllUserHasMultiplePosts(),new UserDto());
//    }
}
