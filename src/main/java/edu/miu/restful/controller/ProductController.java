package edu.miu.restful.controller;

import edu.miu.restful.aspect.annotation.ExecutionTime;
import edu.miu.restful.aspect.annotation.LogMe;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ProductDto> getAll() {
        return productService.findAll();
    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<ProductDto> getAll(@RequestParam(value = "filter" ,required = false) Integer price) {
//        return price==null?productService.findAll():productService.findAllPriceGreaterThan(price);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody ProductDto p) {
        productService.save(p);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId, @RequestBody String name) {
        productService.update(productId, name);
    }


    // FOR DEMO PURPOSES
    @GetMapping("/{productId}/{reviewId}")
    public Review mapDemo(@PathVariable Map<String, Integer> pathVariables) {
        int pid = pathVariables.get("productId");
        int reviewId = pathVariables.get("reviewId");
        return null;
    }

    // FOR DEMO PURPOSES
//    @GetMapping(value =
//            {
//                    "/handlingMultipleEndpoints",
//                    "/handlingMultipleEndpoints/{id}"
//            })
//    public String multipleEndpointsDemo(@PathVariable(required = false) String id) {
//        if (id != null) {
//            return "ID: " + id;
//        } else {
//            return "ID missing";
//        }
//    }

//    @GetMapping("/map-test/{author}/{title}")
//    public String mapInPathVariable(@PathVariable Map<String, String> vals){
//
//        return "author: " + vals.get("author") + "   " + "title: " + vals.get("title");
//    }

    @GetMapping("/filterby/{price}")
    public List<ProductDto> filterByPrice (@PathVariable int price) {
        return productService.findAllByPriceGreaterThan(price);
    }

//    @GetMapping("/test-detach")
//    public void test(){
//        productService.testData();
//    }

}
