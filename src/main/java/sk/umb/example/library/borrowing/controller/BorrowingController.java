package sk.umb.example.library.borrowing.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController {
    @GetMapping("/api/borrowing")
    public List getListResource(){
        System.out.println("search list resource.");
        return null;
    }

    @GetMapping("/api/borrowing/{borrowingId}")
    public void retrieveDetail(@PathVariable Long borrowingId){
        System.out.println("Retrieve detail.");
    }

    @PostMapping("/api/borrowing")
    public void createResource(){
        System.out.println("Create resource:");
    }

    @PutMapping("/api/borrowing/{borrowingId}")
    public void updateResource(@PathVariable Long borrowingId){
        System.out.println("Update resource: ID = " + borrowingId);
    }

    @DeleteMapping("/api/borrowing/{borrowingId}")
    public void deleteResource(@PathVariable Long borrowingId){
        System.out.println("Delete resource: ID = " + borrowingId);
    }
}
