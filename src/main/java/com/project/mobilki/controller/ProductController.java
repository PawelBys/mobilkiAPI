package com.project.mobilki.controller;

import com.project.mobilki.entity.Product;
import com.project.mobilki.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost/", allowedHeaders = "*", allowCredentials = "true")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @PostMapping("/addproducts")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Optional<Product> getProduct(@RequestParam Long id){
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Product> searchProduct(@RequestParam String productName){
        return productService.searchProduct(productName);
    }

    @RequestMapping(value = "/searchid", method = RequestMethod.GET)
    public Product searchProduct(@RequestParam Long id){
        return productService.searchProductId(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteWithId(@RequestParam Long id){
        productService.deleteWithId(id);
    }

    @RequestMapping(value = "/killall", method = RequestMethod.DELETE)
    public void deleteAll(){productService.deleteAll();}

}