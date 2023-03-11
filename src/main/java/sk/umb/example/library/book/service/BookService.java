package sk.umb.example.library.book.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sk.umb.example.library.book.persistence.entity.BookEntity;
import sk.umb.example.library.book.persistence.repository.BookRepository;
import sk.umb.example.library.customer.service.CustomerRequestDto;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDetailDto> getAllBooks() {
        return mapToDtoList(bookRepository.findAll());
    }

    public BookDetailDto getSingleBook(Long bookId){ return mapToDto(bookRepository.findById(bookId).get());}

    public void updateBook(Long bookId, BookRequestDto bookRequestDto){
        BookEntity bookEntity = bookRepository.findById(bookId).get();

        bookEntity.setAuthorFirstName(bookRequestDto.getAuthorFirstName());
        bookEntity.setAuthorLastName(bookRequestDto.getAuthorLastName());
        bookEntity.setTitle(bookRequestDto.getTitle());
        bookEntity.setIsbn(bookRequestDto.getIsbn());
        bookEntity.setCount(bookRequestDto.getCount());

        bookRepository.save(bookEntity);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public Long createBook(BookRequestDto bookRequestDto){
        BookEntity bookEntity = mapToEntity(bookRequestDto);
        BookEntity saved = bookRepository.save(bookEntity);

        return saved.getId();
    }

    private List<BookDetailDto> mapToDtoList(List<BookEntity> bookEntities) {
        List<BookDetailDto> books = new ArrayList<>();

        for (int i = 0; i < bookEntities.size(); i++) {
            BookDetailDto dto = mapToDto(bookEntities.get(i));
            books.add(dto);
        }
        return books;

    }

    private BookEntity mapToEntity(BookRequestDto bookRequestDto){
        BookEntity book = new BookEntity();
        book.setAuthorFirstName(bookRequestDto.getAuthorFirstName());
        book.setAuthorLastName(bookRequestDto.getAuthorLastName());
        book.setTitle(bookRequestDto.getTitle());
        book.setIsbn(bookRequestDto.getIsbn());
        book.setCount(bookRequestDto.getCount());

        return book;
    }

    private BookDetailDto mapToDto(BookEntity bookEntity) {
        BookDetailDto dto = new BookDetailDto();
        dto.setId(bookEntity.getId());
        dto.setAuthorFirstName(bookEntity.getAuthorFirstName());
        dto.setAuthorLastName(bookEntity.getAuthorLastName());
        dto.setTitle(bookEntity.getTitle());
        dto.setIsbn(bookEntity.getIsbn());
        dto.setCount(bookEntity.getCount());

        return dto;
    }
}
