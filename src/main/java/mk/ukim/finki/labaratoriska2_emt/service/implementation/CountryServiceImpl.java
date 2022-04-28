package mk.ukim.finki.labaratoriska2_emt.service.implementation;

import mk.ukim.finki.labaratoriska2_emt.exceptions.countryNotFoundByIdException;
import mk.ukim.finki.labaratoriska2_emt.model.Country;
import mk.ukim.finki.labaratoriska2_emt.repository.CountryRepository;
import mk.ukim.finki.labaratoriska2_emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(() -> new countryNotFoundByIdException("Invalid country id " + id));
    }

    @Override
    public Country save(String name, String continent) {
        Country country = new Country(name , continent);
        return this.countryRepository.save(country);
    }

    @Override
    public Country deleteById(Long id) {
        Country country = this.countryRepository.findById(id).orElseThrow(() -> new countryNotFoundByIdException("Invalid country id " + id));
        this.countryRepository.deleteById(id);
        return country;
    }
}
