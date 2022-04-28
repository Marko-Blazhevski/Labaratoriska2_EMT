package mk.ukim.finki.labaratoriska2_emt.service;

import mk.ukim.finki.labaratoriska2_emt.model.Book;
import mk.ukim.finki.labaratoriska2_emt.model.Category;
import mk.ukim.finki.labaratoriska2_emt.model.dto.BookDto;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(Long id);

    Book save (BookDto bookDto);

    Book edit (Long id , BookDto bookDto);

    Book delete(Long id);

    Book markAsTaken(Long id);

}
