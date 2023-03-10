package sk.umb.example.library.book.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @GetMapping("/api/book")
    public List getListResource(){
        System.out.println("search list resource.");
        return null;
    }

    @GetMapping("/api/book/{bookId}")
    public void retrieveDetail(@PathVariable Long bookId){
        System.out.println("Retrieve detail.");
    }

    @PostMapping("/api/book")
    public void createResource(){
        System.out.println("Create resource:");
    }

    @PutMapping("/api/book/{bookId}")
    public void updateResource(@PathVariable Long bookId){
        System.out.println("Update resource: ID = " + bookId);
    }

    @DeleteMapping("/api/book/{bookId}")
    public void deleteResource(@PathVariable Long bookId){
        System.out.println("Delete resource: ID = " + bookId);
    }
}
