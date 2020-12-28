package com.dilanka_a.springbootmysql.service;

import com.dilanka_a.springbootmysql.entity.product;
import com.dilanka_a.springbootmysql.repositary.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public product saveProduct(product pd) {
        return repository.save(pd);
    }

    public List<product> saveProducts(List<product> pd) {
        return repository.saveAll(pd);
    }

    public List<product> getProducts() {
        return repository.findAll();
    }

    public product getProductByid(int id) {
        return repository.findById(id).orElse(null);
    }

    public product getProductName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product deleted " + id;
    }

    public product updateroduct(product newProduct){
        product existingProduct =  repository.findById(newProduct.getId()).orElse(null);
        existingProduct.setName(newProduct.getName());
        existingProduct.setQuantity(newProduct.getQuantity());
        existingProduct.setPrice(newProduct.getPrice());
        return repository.save(existingProduct);
    }

    public Collection<product> getProductNameSAME(String name) {
        return repository.findAllActiveProducts(name);
    }

    public List<product> getAllProductswithDep(int id){
        List<product> products = new ArrayList<>();
        repository.findByDepartmentName(id).forEach(products::add);
        return products;
    }

}
