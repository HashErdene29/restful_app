package edu.miu.restful.entity.dto;

import edu.miu.restful.entity.Post;
import lombok.Data;

import java.util.List;
@Data
public class UserDetailDto {
    private long id;
    private String name;
    private List<Post> posts;
}
