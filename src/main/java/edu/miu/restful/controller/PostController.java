package edu.miu.restful.controller;

import edu.miu.restful.aspect.annotation.ExecutionTime;
import edu.miu.restful.aspect.annotation.LogMe;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.ProductDto;
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

    @ResponseStatus(HttpStatus.OK)
    @ExecutionTime
    @LogMe
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "filter" ,required = false) String author) {
        return author == null ? postService.findAll() : postService.findAllByAuthor(author);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @LogMe
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id) {
        var product = postService.getById(id);
        return ResponseEntity.ok(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody String title) {
        postService.update(id, title);
    }
    @GetMapping("/filterby/{title}")
    public List<PostDto> filterByTitle (@PathVariable String title) {
        return postService.findAllByTitle(title);
    }
}