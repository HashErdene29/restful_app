package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.LoggerDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.LoggerRepo;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepo loggerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<LoggerDto> findAll() {
        return (List<LoggerDto>) listMapper.mapList(loggerRepo.findAll(),new LoggerDto());}

    @Override
    public LoggerDto getById(int id) {
        return modelMapper.map(loggerRepo.getById(id), LoggerDto.class);
    }


    @Override
    public void save(LoggerDto p) {
        loggerRepo.save(modelMapper.map(p, Logger.class));
    }

    @Override
    public void delete(int id) {
        loggerRepo.deleteById(id);
    }

    @Override
    public void update(int id, String operation) {
        loggerRepo.updateOperationsById(id, operation);
    }
}
