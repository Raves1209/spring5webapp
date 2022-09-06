package practice.springinitializer.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import practice.springinitializer.springapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
