package edu.miu.restful.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
}
