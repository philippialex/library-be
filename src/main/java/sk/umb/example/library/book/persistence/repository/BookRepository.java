package sk.umb.example.library.book.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.book.persistence.entity.BookEntity;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}