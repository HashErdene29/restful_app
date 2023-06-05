package edu.miu.restful.repo;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

//    public Review getReviewByProductId(int pId, int reviewId);

    @Override
    List<Product> findAll();

    void deleteById(int id);
    @Modifying
    @Query("UPDATE Product p set p.name = :name where p.id = :id")
    long updateNameById(@Param("id") int id, @Param("name") String name);
    List<Product>findAllByPriceGreaterThan(int price);
}
