package mk.ukim.finki.labaratoriska2_emt.service.implementation;

import mk.ukim.finki.labaratoriska2_emt.exceptions.authorNotFoundByIdException;
import mk.ukim.finki.labaratoriska2_emt.exceptions.countryNotFoundByIdException;
import mk.ukim.finki.labaratoriska2_emt.model.Author;
import mk.ukim.finki.labaratoriska2_emt.model.Country;
import mk.ukim.finki.labaratoriska2_emt.repository.AuthorRepository;
import mk.ukim.finki.labaratoriska2_emt.repository.CountryRepository;
import mk.ukim.finki.labaratoriska2_emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new authorNotFoundByIdException("Invalid author id " + id));
    }

    @Override
    public Author save(String name, String surname, Long country) {
        Country c = this.countryRepository.findById(country).orElseThrow(() -> new countryNotFoundByIdException("Invalid country id " + country));
        Author author = new Author(name,surname,c);
        return this.authorRepository.save(author);
    }

    @Override
    public Author delete(Long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new authorNotFoundByIdException("Invalid author id " + id));
        this.authorRepository.deleteAuthorById(id);
        return author;
    }
}
