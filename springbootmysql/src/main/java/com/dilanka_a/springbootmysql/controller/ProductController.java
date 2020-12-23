package com.dilanka_a.springbootmysql.controller;

import com.dilanka_a.springbootmysql.entity.product;
import com.dilanka_a.springbootmysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @GetMapping("/productbyid/{id}")
    public product findProductByID(@PathVariable int id) {
        return productService.getProductByid(id);
    }

    @GetMapping("/product/{name}")
    public product findProductByName(@PathVariable String name) {
        return productService.getProductName(name);
    }

    @PutMapping("/updateProduct")
    public product updateProduct(@RequestBody product product) {
        return productService.updateroduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductByID(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/productsame/{name}")
    public Collection<product> findProductByNamesame(@PathVariable String name) {
        return productService.getProductNameSAME(name);
    }


}
