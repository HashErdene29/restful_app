package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.ProductRepo;
import edu.miu.restful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    EntityManager em;

    ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

//    @Override
//    public Review getReviewByProductId(int pId, int reviewId){
//        return productRepo.getReviewByProductId(pId, reviewId);
//    }

    @Override
    public List<ProductDto>findAllByPriceGreaterThan(int price){
        return (List<ProductDto>) listMapper.mapList(productRepo.findAllByPriceGreaterThan(price),new ProductDto());}


}
