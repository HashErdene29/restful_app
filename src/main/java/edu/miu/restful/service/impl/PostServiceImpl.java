package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());}


    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }


    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id,  PostDto p) {
        postRepo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto>findAllAuthorByName(String author){
        return (List<PostDto>) listMapper.mapList(postRepo.findAllAuthorByName(author),new PostDto());}

}
