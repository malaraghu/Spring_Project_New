package com.raghu.project3.controller;

import com.raghu.project3.model.ProductDetails;
import com.raghu.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public List<ProductDetails> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/product/{pId}") // TO USE {Pid} THIS ONE WE NEED TO @PathVariable to work
    public ProductDetails getProductById(@PathVariable int pId){
        return productService.getProductById(pId);
    }
    @PostMapping("/product")
    public void addProd(@RequestBody ProductDetails p){
        /*SINCE WE ARE NOT DOING THE @RequestBody so for that we need to add annotation called @RequestBody*/
         productService.addProduct(p);
    }
    //added in the office

    @PutMapping("/product")
    public String updateProd(@RequestBody ProductDetails p){
        System.out.println("------update-----"+p);
        return productService.updateProd(p);
    }

    @DeleteMapping("/product/{pId}")
    public String deleteProd(@PathVariable int pId){
        return productService.deleteProd(pId);
    }

}
