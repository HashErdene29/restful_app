package edu.miu.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private String category;
    private int starCount;
     // ....
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviews;

    public Product(int id, String name, float price, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.reviews = reviews;
    }
}
