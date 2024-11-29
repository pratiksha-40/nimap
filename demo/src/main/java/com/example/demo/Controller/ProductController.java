package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductServices;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductServices ps;
    

    // Pagination for products
    @GetMapping("/showProduct")
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page, 
                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);  // Creating Pageable instance for pagination
        return ps.getProduct(pageable);  // Pagination handled here
    }

    @GetMapping("showproduct")
    public List<Product> getMapping(){
        return ps.getProduct();
    }

    @PostMapping("addproduct")
    public String addCategory(@RequestBody Product pp) {
       
        return ps.addProductService(pp);
    }
    
    @GetMapping("showproduct/{id}")
    public List<Product> getMapping(@PathVariable int id){
        return ps.getProduct();
    }

    @DeleteMapping("deleteproduct/{id}")
    public String deleteCategory(@PathVariable int id,@RequestBody Product pp){
        return ps.deleteProductService(pp);
    }

    @PutMapping("updateproduct/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product pp) {
        return ps.updateProductService(pp);
    }
}
