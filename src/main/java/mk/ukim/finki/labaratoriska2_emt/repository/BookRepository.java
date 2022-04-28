package mk.ukim.finki.labaratoriska2_emt.repository;

import mk.ukim.finki.labaratoriska2_emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book , Long> {
    void deleteBookById(Long id);
}
