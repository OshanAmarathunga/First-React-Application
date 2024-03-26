package com.ijse.firstSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int qty;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "orderProducts")
    private List<Order> orders;


}
