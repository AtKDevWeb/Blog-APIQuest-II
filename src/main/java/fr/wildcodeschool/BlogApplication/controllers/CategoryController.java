package fr.wildcodeschool.BlogApplication.controllers;

import fr.wildcodeschool.BlogApplication.models.Category;
import fr.wildcodeschool.BlogApplication.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;
    //Methode CRUD
    //Create
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    //Read All
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categories);
        }
        return ResponseEntity.ok().body(categories);
    }
    //Read One
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category savedCategory = categoryRepository.findById(id).orElse(null);
        if (savedCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(savedCategory);
    }
    @GetMapping("/search-name")
    public ResponseEntity<List<Category>> searchCategoryByName(@RequestParam String name) {
        List<Category> categories = categoryRepository.findByName(name);
        if (categories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(categories);
    }
    //UpDate
    @PutMapping("/{id}")
    public ResponseEntity<Category> upDateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }else{
            category.setName(category.getName());
            Category updatedCategory = categoryRepository.save(category);
            return ResponseEntity.ok().body(updatedCategory);
        }
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.delete(category);
        return ResponseEntity.noContent().build();
    }
}
