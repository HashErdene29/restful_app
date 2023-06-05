package edu.miu.restful.repo;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


//    public Review getReviewByProductId(int pId, int reviewId);

    List<Product>findAllByPriceGreaterThan(int price);
}
