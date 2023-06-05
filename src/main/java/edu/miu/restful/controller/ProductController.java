package edu.miu.restful.controller;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // FOR DEMO PURPOSES
    @GetMapping("/{productId}/{reviewId}")
    public Review mapDemo(@PathVariable Map<String, Integer> pathVariables) {
        int pid = pathVariables.get("productId");
        int reviewId = pathVariables.get("reviewId");
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
