package com.project.mobilki.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "t_product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "bar_code")
    private String bar_code;

}