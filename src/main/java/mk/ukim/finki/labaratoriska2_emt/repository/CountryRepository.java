package mk.ukim.finki.labaratoriska2_emt.repository;

import mk.ukim.finki.labaratoriska2_emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country , Long> {

    void deleteCountryById(Long id);

}
