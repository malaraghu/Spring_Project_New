package com.raghu.project3.service;

import com.raghu.project3.model.Product;
import com.raghu.project3.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    public List<Product> getProducts() {
        return  repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }
}
