package edu.miu.restful.service;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<ProductDto>findAllByPriceGreaterThan(int price);
}
