package edu.miu.restful.entity;

import ch.qos.logback.core.util.TimeUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "log_id_seq_gen")
    @SequenceGenerator(name = "log_id_seq_gen", sequenceName = "entity_sequence", initialValue = 500, allocationSize = 1)
    private int id;
    private Date date;
    private long time;
    private String principle;
    private String operation;

    public Logger(Date date, long time, String principle, String operation){
        this.date = date;
        this.time = time;
        this.principle = principle;
        this.operation = operation;
    }
}
