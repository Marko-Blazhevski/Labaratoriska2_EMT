package mk.ukim.finki.labaratoriska2_emt.service.implementation;

import mk.ukim.finki.labaratoriska2_emt.exceptions.bookNotFoundByIdException;
import mk.ukim.finki.labaratoriska2_emt.model.Author;
import mk.ukim.finki.labaratoriska2_emt.model.Book;
import mk.ukim.finki.labaratoriska2_emt.model.dto.BookDto;
import mk.ukim.finki.labaratoriska2_emt.repository.AuthorRepository;
import mk.ukim.finki.labaratoriska2_emt.repository.BookRepository;
import mk.ukim.finki.labaratoriska2_emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new bookNotFoundByIdException("Invalid book id " + id));
    }

    @Override
    public Book save(BookDto bookDto) {
        Author author = this.authorRepository.getById(bookDto.getAuthorId());
        Book book = new Book(bookDto.getName() , bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return this.bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new bookNotFoundByIdException("Invalid book id " + id));
        Author author = this.authorRepository.getById(bookDto.getAuthorId());
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return this.bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new bookNotFoundByIdException("Invalid book id " + id));
        this.bookRepository.deleteBookById(id);
        return book;
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book = this.findById(id);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return this.bookRepository.save(book);
    }
}
