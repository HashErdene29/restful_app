package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.CommentRepo;
import edu.miu.restful.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapper.mapList(commentRepo.findAll(),new CommentDto());}

    @Override
    public CommentDto getById(long id) {
        return modelMapper.map(commentRepo.getById(id), CommentDto.class);
    }


    @Override
    public void save(CommentDto p) {
        commentRepo.save(modelMapper.map(p, Comment.class));
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(long id, String name) {
        commentRepo.updateNameById(id, name);
    }
}
