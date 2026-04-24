package com.raghu.project3.service;

import com.raghu.project3.model.Product;
import com.raghu.project3.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addProduct_image(Product p, MultipartFile imageData) throws IOException {
        p.setImageName(imageData.getOriginalFilename());
        p.setImageType(imageData.getContentType());
        p.setImageData(imageData.getBytes());
        return repo.save(p);
    }
}
