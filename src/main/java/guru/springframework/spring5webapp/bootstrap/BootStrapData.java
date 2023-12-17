package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Author  eric = new Author("Eric", "Evans");
        Book ddd= new Book("Domain Driven Design","123123");
        Publisher kindle = new Publisher("Kindle","Amazon St1");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        kindle.getBook().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(kindle);

        Author  rod = new Author("Rod", "Johnson");
        Book noEJB= new Book("J2EE Development without EJB","3939456456");
        Publisher wrox= new Publisher("Wrox","England. Wrox");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        wrox.getBook().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(wrox);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers" + publisherRepository.count());

    }
}
