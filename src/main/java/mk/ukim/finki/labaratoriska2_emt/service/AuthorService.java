package mk.ukim.finki.labaratoriska2_emt.service;

import mk.ukim.finki.labaratoriska2_emt.model.Author;
import mk.ukim.finki.labaratoriska2_emt.model.Country;

import java.util.List;

public interface AuthorService {

    List<Author> listAll();

    Author findById(Long id);

    Author save (String name, String surname, Long country);

    Author delete(Long id);

}
