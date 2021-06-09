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
    private Long barcode;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    @Column(name = "company")
    private String company;

}