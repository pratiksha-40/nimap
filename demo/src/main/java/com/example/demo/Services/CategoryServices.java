package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository cr;
    public List<Category> getCategory(){
		
		return cr.findAll();
		
	}
    //Pagination method
    public Page<Category> getCategory(Pageable pageable) {
        return cr.findAll(pageable);  // Pagination handled by Spring Data
    }

    public String addCategoryService(Category cc){
        cr.save(cc);
        return "Added Category";
    }

    public String deleteCategoryService(Category cc){
        cr.delete(cc); 
        return "Removed Category";
    }

    public String updateCategoryService(Category cc){
        cr.save(cc);
        return "Update Successfully";
    }
}
