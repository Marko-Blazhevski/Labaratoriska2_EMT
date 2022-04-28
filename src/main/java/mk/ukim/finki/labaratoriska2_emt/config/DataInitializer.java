package mk.ukim.finki.labaratoriska2_emt.config;

import mk.ukim.finki.labaratoriska2_emt.model.Author;
import mk.ukim.finki.labaratoriska2_emt.model.Category;
import mk.ukim.finki.labaratoriska2_emt.model.Country;
import mk.ukim.finki.labaratoriska2_emt.model.dto.BookDto;
import mk.ukim.finki.labaratoriska2_emt.service.AuthorService;
import mk.ukim.finki.labaratoriska2_emt.service.BookService;
import mk.ukim.finki.labaratoriska2_emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;


    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {

        Country country = this.countryService.save("Macedonia" , "Europe");
        Author author = this.authorService.save("Marko" , "Blazveski" , country.getId());

        this.bookService.save(new BookDto("Book 1" , Category.DRAMA, author.getId() , 100));
        this.bookService.save(new BookDto("Book 2" , Category.BIOGRAPHY, author.getId() , 200));
        this.bookService.save(new BookDto("Book 3" , Category.CLASSICS, author.getId() , 300));
        this.bookService.save(new BookDto("Book 4" , Category.FANTASY, author.getId() , 400));
        this.bookService.save(new BookDto("Book 5" , Category.HISTORY, author.getId() , 500));
        this.bookService.save(new BookDto("Book 6" , Category.NOVEL, author.getId() , 600));
        this.bookService.save(new BookDto("Book 7" , Category.THRILLER, author.getId() , 700));
        this.bookService.save(new BookDto("Book 8" , Category.DRAMA, author.getId() , 800));
        this.bookService.save(new BookDto("Book 9" , Category.BIOGRAPHY, author.getId() , 900));
        this.bookService.save(new BookDto("Book 10" , Category.NOVEL, author.getId() , 1000));
    }

}
