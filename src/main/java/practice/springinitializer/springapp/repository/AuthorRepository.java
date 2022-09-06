package practice.springinitializer.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import practice.springinitializer.springapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
