package com.dilanka_a.springbootmysql.controller;

import com.dilanka_a.springbootmysql.entity.product;
import com.dilanka_a.springbootmysql.service.ProductService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public product addProduct(@RequestBody product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<product> addProducts(@RequestBody List<product> product) {
        return productService.saveProducts(product);
    }

    @GetMapping("/findAllProducts")
    public List<product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public product findProductByID(@PathVariable("id") int id) {
        return productService.getProductByid(id);
    }

    @GetMapping("/product/{name}")
    public product findProductByName(@PathVariable("name") String name) {
        return productService.getProductName(name);
    }

    @PutMapping("/updateProduct")
    public product updateProduct(@RequestBody product product) {
        return productService.updateroduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public product deleteProductByID(@PathVariable("id") int id) {
        return productService.getProductByid(id);
    }

}
