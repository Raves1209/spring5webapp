package practice.springinitializer.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import practice.springinitializer.springapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
