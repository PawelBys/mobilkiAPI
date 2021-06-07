package com.project.mobilki.services;

import com.project.mobilki.entity.Product;
import com.project.mobilki.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long barcode){
        return productRepository.findById(barcode);
    }

    public List<Product> searchProduct(String productName){
        return productRepository.searchFor(productName);
    }

    public Product searchProductId(Long barcode){
        return productRepository.searchForId(barcode);
    }

    public void deleteWithId(Long barcode){
        productRepository.deleteId(barcode);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }

}