package mk.ukim.finki.labaratoriska2_emt.service;

import mk.ukim.finki.labaratoriska2_emt.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> listAll();

    Country findById(Long id);

    Country save(String name , String continent);

    Country deleteById(Long id);

}
