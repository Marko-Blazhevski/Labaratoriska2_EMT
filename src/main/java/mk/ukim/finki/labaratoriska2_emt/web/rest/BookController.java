package mk.ukim.finki.labaratoriska2_emt.web.rest;

import mk.ukim.finki.labaratoriska2_emt.model.Author;
import mk.ukim.finki.labaratoriska2_emt.model.Book;
import mk.ukim.finki.labaratoriska2_emt.model.Category;
import mk.ukim.finki.labaratoriska2_emt.model.Country;
import mk.ukim.finki.labaratoriska2_emt.model.dto.BookDto;
import mk.ukim.finki.labaratoriska2_emt.service.AuthorService;
import mk.ukim.finki.labaratoriska2_emt.service.BookService;
import mk.ukim.finki.labaratoriska2_emt.service.CountryService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://emttt-frontend.herokuapp.com/")
@RequestMapping({"/" , "/books"})
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BookController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    // list all books
    @GetMapping
    public List<Book> listAll() {
        return this.bookService.listAll();
    }

    // list all categories
    @GetMapping("/categories")
    public List<Category> listAllCategories() {
        return Arrays.asList(Category.values());
    }

    // list all authors
    @GetMapping("/authors")
    public List<Author> listAllAuthors() {return this.authorService.listAll();}

    // list all countries
    @GetMapping("/countries")
    public List<Country> listAllCountries() {return this.countryService.listAll();}

    // get a book by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return this.bookService.findById(id);
    }

    // save
    @PostMapping("/save")
    public Book save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto);
    }

    //edit
    @PutMapping("/update/{id}")
    public Book edit(@PathVariable Long id , @RequestBody BookDto bookDto){
        return this.bookService.edit(id , bookDto);
    }

    //mark as taken
    @PutMapping("/taken/{id}")
    public Book markAsTaken(@PathVariable Long id){
        return this.bookService.markAsTaken(id);
    }

    //delete
    @Transactional
    @DeleteMapping("/delete/{id}")
    public Book deleteBookById(@PathVariable Long id) {
        return this.bookService.delete(id);
    }
}
