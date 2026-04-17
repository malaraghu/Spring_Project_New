package com.raghu.project3.model;

import org.springframework.stereotype.Component;

@Component
public class ProductDetails {
    private int pId;
    private String pName;
    private int pCost;

    public ProductDetails(){
    }

    public ProductDetails(int pId, String pName, int pCost) {
        this.pId = pId;
        this.pName = pName;
        this.pCost = pCost;
    }


    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public int getPCost() {
        return pCost;
    }

    public void setPCost(int pCost) {
        this.pCost = pCost;
    }

    @Override
    public String toString() { // THIS USED TO CONVERT THE CLIENT DATA TO STRING TYPE
                                // OTHERWISE IT WILL PRINT ADDRESS
        return "ProductDetails{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pCost=" + pCost +
                '}';
    }
}
