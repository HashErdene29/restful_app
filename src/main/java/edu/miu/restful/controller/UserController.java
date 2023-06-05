package edu.miu.restful.controller;

import edu.miu.restful.entity.Post;
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

//    @GetMapping("/{id}/posts")
//    public UserDetailDto getPostsByUserId(@PathVariable int id) {
//        return userService.getPostsByUserId(id);
//    }
//
//    @GetMapping("/{id}/posts/{postId}") // WITHOUT DTO
//    public Post getPostsByUserId(@PathVariable("id") int uId, @PathVariable("postId") int postId) {
//        return userService.getPostsByUserId(uId, postId);
//    }


    // FOR DEMO PURPOSES
    @GetMapping("/{userId}/{postId}")
    public Post mapDemo(@PathVariable Map<String, Integer> pathVariables) {
        int uId = pathVariables.get("userId");
        int postId = pathVariables.get("postId");
        return null;
    }

    // FOR DEMO PURPOSES
    @GetMapping(value =
            {
                    "/handlingMultipleEndpoints",
                    "/handlingMultipleEndpoints/{id}"
            })
    public String multipleEndpointsDemo(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/multipleposts")
//    public List<UserDto> getAllUserWithMultiplePost() {
//        return userService.findAllUserHasMultiplePosts();
//    }
}
