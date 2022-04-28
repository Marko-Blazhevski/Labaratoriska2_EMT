package mk.ukim.finki.labaratoriska2_emt.repository;

import mk.ukim.finki.labaratoriska2_emt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    void deleteAuthorById(Long id);
}
