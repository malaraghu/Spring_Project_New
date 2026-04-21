package com.raghu.project3.repo;

import com.raghu.project3.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDetails,Integer> {
}
