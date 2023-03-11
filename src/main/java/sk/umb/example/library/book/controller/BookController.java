package sk.umb.example.library.book.controller;

import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.book.service.BookRequestDto;
import sk.umb.example.library.book.service.BookService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookDetailDto> getBooks(){
        System.out.println("search list resource.");
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/{bookId}")
    public BookDetailDto bookDetail(@PathVariable Long bookId){
        System.out.println("Retrieve detail.");
        return bookService.getSingleBook(bookId);
    }

    @PostMapping("/api/books")
    public Long createBook(@RequestBody BookRequestDto bookRequestDto){
        System.out.println("Create resource:");
        return bookService.createBook(bookRequestDto);
    }

    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable Long bookId, @RequestBody BookRequestDto bookRequestDto ){
        System.out.println("Update resource: ID = " + bookId);
        bookService.updateBook(bookId, bookRequestDto);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        System.out.println("Delete resource: ID = " + bookId);
        bookService.deleteBook(bookId);
    }

}
