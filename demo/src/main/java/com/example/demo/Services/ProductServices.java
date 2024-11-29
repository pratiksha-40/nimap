package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository pr;
    public List<Product> getProduct(){
		
		return pr.findAll();
	}

    // Pagination method
    public Page<Product> getProduct(Pageable pageable) {
        return pr.findAll(pageable);  // Pagination handled by Spring Data
    }
    public String addProductService(Product pp){
        pr.save(pp);
        return "Added product";
    }

    public String deleteProductService(Product pp){
        pr.delete(pp); 
        return "Removed Product";
    }

    public String updateProductService(Product pp){
        pr.save(pp);
        return "Update Successfully";
    }
}
