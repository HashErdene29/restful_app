package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    EntityManager em;

    private final ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<ProductDto> findAll() {
        return (List<ProductDto>) listMapper.mapList(productRepo.findAll(), new ProductDto()); }


    public ProductDto getById(int id) {
        return modelMapper.map(productRepo.getById(id), ProductDto.class);
    }

    @Override
    public void save(ProductDto p) {
        productRepo.save(modelMapper.map(p, Product.class));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public void update(int id, String name) {
        productRepo.updateNameById(id, name);
    }

    @Override
    public List<ProductDto>findAllByPriceGreaterThan(int price){
        return (List<ProductDto>) listMapper.mapList(productRepo.findAllByPriceGreaterThan(price),new ProductDto());}

    public void testData(){
        var product = productRepo.findById(111).orElse(null);
        em.detach(product);
        product.setName("CHANGED!");
        System.out.println(product.getName());
    }
}
