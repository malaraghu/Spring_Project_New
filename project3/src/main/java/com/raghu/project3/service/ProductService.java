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

    public Product getProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct_image(Product p, MultipartFile imageData) throws IOException {
        p.setImageName(imageData.getOriginalFilename());
        p.setImageType(imageData.getContentType());
        p.setImageData(imageData.getBytes());
        return repo.save(p);
    }

    public Product updateProduct(int id, Product p, MultipartFile imageData) throws IOException {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(p.getName());
        existing.setDesc(p.getDesc());
        existing.setBrand(p.getBrand());
        existing.setPrice(p.getPrice());
        existing.setCatagery(p.getCatagery());
        existing.setReleaseDate(p.getReleaseDate());
        existing.setAvailable(p.isAvailable());
        existing.setQuantity(p.getQuantity());

        // ✅ Only update image if new one is provided
        if (imageData != null && !imageData.isEmpty()) {
            existing.setImageName(imageData.getOriginalFilename());
            existing.setImageType(imageData.getContentType());
            existing.setImageData(imageData.getBytes());
        }

        return repo.save(existing);
    }

    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Delete success";
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProductInDB(keyword);
    }
}
