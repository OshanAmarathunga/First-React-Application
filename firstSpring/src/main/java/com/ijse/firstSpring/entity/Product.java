package com.ijse.firstSpring.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
