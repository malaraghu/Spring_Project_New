package com.raghu.project3.controller;

import com.raghu.project3.model.Product;
import com.raghu.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin // Allows frontend to communicate
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService prodServ;

    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(prodServ.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/getproducts/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product p = prodServ.getProductById(id);
        if (p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct_image(
            @RequestPart("product") Product p,
            @RequestPart("imageFile") MultipartFile imageData
    ) {
        try {
            Product p1 = prodServ.addProduct_image(p, imageData);
            return new ResponseEntity<>(p1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getimageData(@PathVariable("id") int id){
        Product p = prodServ.getProductById(id);

        if (p == null || p.getImageData() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        byte[] im = p.getImageData();
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(p.getImageType()))
                .body(im);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id,
            @RequestPart("product") Product p,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageData
    ) {
        try {
            Product pr = prodServ.updateProduct(id, p, imageData);
            if (pr != null) {
                return new ResponseEntity<>("update success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            return new ResponseEntity<>("Error processing image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to update: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product p = prodServ.getProductById(id);
        if (p != null)
            return new ResponseEntity<>(prodServ.deleteProduct(id), HttpStatus.OK);
        else
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}