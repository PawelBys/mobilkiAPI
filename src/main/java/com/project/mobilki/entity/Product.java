package com.project.mobilki.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @Column(name = "barcode")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long barcode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "weight")
    private int weight;

}