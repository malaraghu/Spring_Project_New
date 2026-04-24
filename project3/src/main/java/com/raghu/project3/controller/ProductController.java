package com.raghu.project3.controller;

import com.raghu.project3.model.Product;
import com.raghu.project3.model.ProductDetails;
import com.raghu.project3.service.ProductDetailsService;
import com.raghu.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin        //@CrossOrigin will be used when front end and backend are running in a different ports
@RequestMapping("/api")
public class ProductController {
    @Autowired  //field injection added in office
    private ProductDetailsService productDetailsService;
    @Autowired
    ProductService prodServ;
/*
    @RequestMapping("/product")
    public List<ProductDetails> getProductsDetails(){
        return productDetailsService.getProductsDetails();
    }
    @GetMapping("/product/{pId}") // TO USE {Pid} THIS FOR @PathVariable to work
    public ProductDetails getProductById1(@PathVariable int pId){
        return productDetailsService.getProductById(pId);
    }
    @PostMapping("/product")
    public void addProd(@RequestBody ProductDetails p){
        *//*SINCE WE ARE NOT DOING THE @RequestBody so for that we need to add annotation called @RequestBody*//*
         productDetailsService.addProduct(p);
    }

    @PutMapping("/product")
    public String updateProd(@RequestBody ProductDetails p){
        System.out.println("------update-----"+p);
        return productDetailsService.updateProd(p);
    }

    @DeleteMapping("/product/{pId}")
    public String deleteProd(@PathVariable int pId){
        return productDetailsService.deleteProd(pId);
    }*/

//    =============================================================================================================

    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getProducts(){
        System.out.println("-----------raghu---------");
        return new ResponseEntity<>(prodServ.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/getproducts/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product p = prodServ.getProductById(id);
        if (p != null)
            return new ResponseEntity<>(p,HttpStatus.OK);
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

}
