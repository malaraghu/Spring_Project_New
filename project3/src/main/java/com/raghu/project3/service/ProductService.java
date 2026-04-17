package com.raghu.project3.service;

import com.raghu.project3.model.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<ProductDetails> pd = new ArrayList<>(Arrays.asList(
            new ProductDetails(101,"phone",50000),
            new ProductDetails(102,"laptop",100000),
            new ProductDetails(103,"cpu",150000)));


    /*Arrays.asList is IMMUTABLE AND ArrayList is MUTABLE*/

    public List<ProductDetails> getProducts(){
        return pd;
    }

    public ProductDetails getProductById(int pId) {
        return pd.stream()
                .filter(p -> p.getPId()==pId)
                .findFirst().orElse(new ProductDetails(100,"no product there",0));
    }

    public void addProduct(ProductDetails p) {
        pd.add(p);
    }

    public String updateProd(ProductDetails p) {
        int index=0;
        for(int i=0;i<pd.size();i++){
            if (pd.get(i).getPId()==p.getPId()){
                index=i;
                pd.set(index,p);
            }

        }

        return "updated to list";
    }

    public String deleteProd(int pId) {
        int index=0;
        for (int i=0;i<pd.size();i++){
            if (pd.get(i).getPId()==pId){
                index=i;
                pd.remove(index);
            }

        }
        return "deleted successfully";
    }

}
