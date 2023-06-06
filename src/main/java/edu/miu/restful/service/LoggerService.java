package edu.miu.restful.service;

import edu.miu.restful.entity.dto.LoggerDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.service.impl.LoggerServiceImpl;

import java.util.List;

public interface LoggerService {
    List<LoggerDto> findAll();

    LoggerDto getById(int id);

    void save(LoggerDto p);

    void delete(int id);

    void update(int id, String operation);
}
