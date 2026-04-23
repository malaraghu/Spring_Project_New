package com.raghu.project3.controller;

import com.raghu.project3.model.Product;
import com.raghu.project3.model.ProductDetails;
import com.raghu.project3.service.ProductDetailsService;
import com.raghu.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin        //@CrossOrigin will be used when front end and backend are running in a different ports
@RequestMapping("/api")
public class ProductController {
    @Autowired  //field injection added in office
    private ProductDetailsService productDetailsService;
    @Autowired
    ProductService prodServ;

    @RequestMapping("/product")
    public List<ProductDetails> getProductsDetails(){
        return productDetailsService.getProductsDetails();
    }
    @GetMapping("/product/{pId}") // TO USE {Pid} THIS FOR @PathVariable to work
    public ProductDetails getProductById(@PathVariable int pId){
        return productDetailsService.getProductById(pId);
    }
    @PostMapping("/product")
    public void addProd(@RequestBody ProductDetails p){
        /*SINCE WE ARE NOT DOING THE @RequestBody so for that we need to add annotation called @RequestBody*/
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
    }

//    =============================================================================================================

    @GetMapping("/getproducts")
    public List<Product> getProducts(){
        return prodServ.getProducts();
    }
}
