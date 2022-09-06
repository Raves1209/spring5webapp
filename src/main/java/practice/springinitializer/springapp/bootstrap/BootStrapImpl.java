package practice.springinitializer.springapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import practice.springinitializer.springapp.domain.Author;
import practice.springinitializer.springapp.domain.Book;
import practice.springinitializer.springapp.domain.Publisher;
import practice.springinitializer.springapp.repository.AuthorRepository;
import practice.springinitializer.springapp.repository.BookRepository;
import practice.springinitializer.springapp.repository.PublisherRepository;

@Component
public class BootStrapImpl implements CommandLineRunner {
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapImpl(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("Ravi", "Cumins Genesis, Hormavau, 560043");
        publisherRepository.save(publisher);

        System.out.println("Publisher count is : " + publisherRepository.count());

        Author ravi = new Author("Ravi", "Bhardwaj");
        Book book1 = new Book("ABCD", "11112222");
        book1.setPublisher(publisher);
        Book book2 = new Book("PQRS", "22221111");
        book2.setPublisher(publisher);

        ravi.getBooks().add(book1);
        ravi.getBooks().add(book2);
        book1.getAuthors().add(ravi);
        book2.getAuthors().add(ravi);

        publisher.getBooks().add(book1);
        publisher.getBooks().add(book2);

        authorRepository.save(ravi);
        bookRepository.save(book1);
        bookRepository.save(book2);
        publisherRepository.save(publisher);
        System.out.println("Book count is : " + bookRepository.count());
        System.out.println("Publisher book count is : " + publisher.getBooks().size());
    }
}
