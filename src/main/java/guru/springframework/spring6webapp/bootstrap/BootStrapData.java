package guru.springframework.spring6webapp.bootstrap;


/*
Created by Zsolt Melich (BT - IVR team)
*/

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstNAme("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstNAme("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EEE Development without EJB");
        noEJB.setIsbn("4439278472");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher libri = new Publisher();
        libri.setPublisherName("Libri Kiado");
        libri.setAddress("15 Kunigunda road");
        libri.setCity("Budapest");
        libri.setState("Pest");
        libri.setZipCode("1141");

        /*
        libri.getBooks().add(noEJBSaved);
        libri.getAuthors().add(rodSaved);

        Publisher libriSaved = publisherRepository.save(libri);
        */
        publisherRepository.save(libri);

        System.out.println("In Bootstrap");
        System.out.println("Author count:"+  authorRepository.count());
        System.out.println("Book count:"+  bookRepository.count());
        System.out.println("Publisher count:"+  publisherRepository.count());


    }
}
