package edu.miu.restful.controller;

import edu.miu.restful.aspect.annotation.ExecutionTime;
import edu.miu.restful.aspect.annotation.LogMe;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.entity.dto.UserDetailDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(HttpStatus.OK)
    @ExecutionTime
    @LogMe
    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto p) {
        userService.save(p);
    }

    @LogMe
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        var user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int userId, @RequestBody String name) {
        userService.update(userId, name);
    }

//    @GetMapping("/filterby/{post_id}")
//    public List<UserDto> filterByPostId (@PathVariable long post_id) {
//        return userService.findAllByPosts(post_id);
//    }

    @GetMapping("/filterby/{n}")
    public List<UserDto> filterUsersByPostCount (@PathVariable int n){ return userService.findUsersByPostCount(n); }

}
