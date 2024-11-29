package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Category;
import com.example.demo.Services.CategoryServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryServices cs;
    
    // Pagination for categories
    @GetMapping("/showCategoryes")
    public Page<Category> getCategories(@RequestParam(defaultValue = "0") int page, 
                                        @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);  // Creating Pageable instance for pagination
        return cs.getCategory(pageable);  // Pagination handled here
    }

    @GetMapping("showCategory")
    public List<Category> getMappings(){
        return cs.getCategory();
    }
    
    @PostMapping("addCategory")
    public String addCategory(@RequestBody Category cc) {
       
        return cs.addCategoryService(cc);
    }

    @GetMapping("showCategory/{id}")
    public List<Category> getMappings(@PathVariable int id){
        return cs.getCategory();
    }
    
    @DeleteMapping("api/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id  ,@RequestBody Category cc){
        return cs.deleteCategoryService(cc);
    }

    @PutMapping("api/update/{id}")
    public String updateCategory(@PathVariable int id, @RequestBody Category cc){
        return cs.updateCategoryService(cc);
    }
}
