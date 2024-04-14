package com.demo.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restapi.entity.Category;
import com.demo.restapi.reposiotry.CategoryReposiotory;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;






@RestController
public class CategoryController {
    
    @Autowired
    CategoryReposiotory repo; 
    
    @GetMapping("/category") 
    public List<Category> getAllCategorys(){ 
        List<Category>categorys = repo.findAll(); 
        
        return categorys;
    }
    
    @GetMapping("/category/{id}")
   public Category getCategory (@PathVariable int id) {
	   Category category =repo.findById(id).get();
	   
	   return category;
	   
   }
    @PostMapping("/category/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createCategory(@RequestBody Category category) {
    	repo.save(category);
    	
    }
    @PutMapping("/category/update/{id}")
    public Category updateCategory(@PathVariable int id) {
        Category category = repo.findById(id).orElse(null);
        if (category != null) {
            category.setProduct_name("Lamp");
            category.setPrice(650.0);
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse("2024-04-14");
                category.setMfg_date(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
                
            }
            category.setProduct_type("show piss");
            repo.save(category);
        }
        return category;
        
        
    }
    @DeleteMapping("/category/delete/{id}")
	public void removeCategory(@PathVariable int id) {
		Category category = repo.findById(id).get();
		repo.delete(category);
	}
}
