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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll();
    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<ProductDto> getAll(@RequestParam(value = "filter" ,required = false) Integer price) {
//        return price==null?productService.findAll():productService.findAllPriceGreaterThan(price);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto p) {
        userService.save(p);
    }

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
    public void update(@PathVariable("id") int userId, @RequestBody UserDto u) {
        userService.update(userId,u);
    }

    @GetMapping("/{id}/posts")
    public UserDetailDto getPostsByUserId(@PathVariable int id) {
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/{id}/posts/{postId}") // WITHOUT DTO
    public Post getPostsByUserId(@PathVariable("id") int uId, @PathVariable("postId") int postId) {
        return userService.getPostsByUserId(uId, postId);
    }


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

    // FOR DEMO PURPOSES
    @GetMapping("/h/{id}")
    public EntityModel<UserDto> getByIdH(@PathVariable int id) {

        UserDto product = userService.getById(id);
        EntityModel<UserDto> resource = EntityModel.of(product);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        resource.add(linkTo.withRel("all-products"));

        return resource;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/multipleposts")
    public List<UserDto> getAllUserWithMultiplePost() {
        return userService.findAllUserHasMultiplePosts();
    }
}
