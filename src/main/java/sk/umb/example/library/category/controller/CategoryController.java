package sk.umb.example.library.category.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @GetMapping("/api/category")
    public List getListResource(){
        System.out.println("search list resource.");
        return null;
    }

    @GetMapping("/api/category/{categoryId}")
    public void retrieveDetail(@PathVariable Long categoryId){
        System.out.println("Retrieve detail.");
    }

    @PostMapping("/api/category")
    public void createResource(){
        System.out.println("Create resource:");
    }

    @PutMapping("/api/category/{categoryId}")
    public void updateResource(@PathVariable Long categoryId){
        System.out.println("Update resource: ID = " + categoryId);
    }

    @DeleteMapping("/api/category/{categoryId}")
    public void deleteResource(@PathVariable Long categoryId){
        System.out.println("Delete resource: ID = " + categoryId);
    }
}
