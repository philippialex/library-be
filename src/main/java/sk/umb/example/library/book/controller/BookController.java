package sk.umb.example.library.book.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @GetMapping("/api/customers")
    public List getListResource(@RequestParam(required = false) String lastName){
        System.out.println("search list resource.");
        return null;
    }

    @GetMapping("/api/customers/{customerId}")
    public void retrieveDetail(@PathVariable Long customerId){
        System.out.println("Retrieve detail.");
    }

    @PostMapping("/api/customers")
    public void createResource(){
        System.out.println("Create resource:");
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateResource(@PathVariable Long customerId){
        System.out.println("Update resource: ID = " + customerId);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteResource(@PathVariable Long customerId){
        System.out.println("Delete resource: ID = " + customerId);
    }
}
