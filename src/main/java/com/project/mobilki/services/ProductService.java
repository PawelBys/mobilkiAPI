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

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> searchProduct(String productName){
        return productRepository.searchFor(productName);
    }

    public Product searchProductId(Long id){
        return productRepository.searchForId(id);
    }

    public void deleteWithId(Long id){
        productRepository.deleteId(id);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }

//    public void updateProduct(long id, String productName, String description, float rating, String img){productRepository.updateProduct(id, productName, description, rating, img);}
}