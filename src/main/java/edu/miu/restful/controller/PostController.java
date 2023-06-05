package edu.miu.restful.controller;

import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<PostDto> getAll() {
//        return postService.findAll();
//    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "filter" ,required = false) String author) {
        if(author!=null) {
            return postService.findAllByAuthor(author);
        }
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

    @GetMapping("/map-test/{author}/{title}")
    public String mapInPathVariable(@PathVariable Map<String, String> vals){
        return "author: " + vals.get("author") + "   " + "title: " + vals.get("title");
    }
}