package edu.miu.restful.entity.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class LoggerDto {
    private int id;
    private Date date;
    private long time;
    private String principle;
    private String operation;
}
