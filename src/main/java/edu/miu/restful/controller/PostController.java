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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll() {
        return postService.findAll();
    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<ProductDto> getAll(@RequestParam(value = "filter" ,required = false) Integer price) {
//        return price==null?productService.findAll():productService.findAllPriceGreaterThan(price);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

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
    public void update(@PathVariable("id") int productId, @RequestBody PostDto p) {
        postService.update(productId,p);
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
    public EntityModel<PostDto> getByIdH(@PathVariable int id) {

        PostDto post = postService.getById(id);
        EntityModel<PostDto> resource = EntityModel.of(post);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        resource.add(linkTo.withRel("all-posts"));

        return resource;
    }

    @GetMapping("/map-test/{author}/{title}")
    public String mapInPathVariable(@PathVariable Map<String, String> vals){
        return "author: " + vals.get("author") + "   " + "title: " + vals.get("title");
    }
}