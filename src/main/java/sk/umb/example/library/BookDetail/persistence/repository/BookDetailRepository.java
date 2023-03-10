package sk.umb.example.library.BookDetail.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;

@Repository
public interface BookDetailRepository extends CrudRepository<CustomerEntity, Long> {
}