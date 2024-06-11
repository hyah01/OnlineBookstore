package genspark.pbc.OnlineBookstore.Repository;

import genspark.pbc.OnlineBookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book,Long> {
    // Custom query to match book name
    @Query("SELECT b FROM Book b WHERE LOWER(b.book_name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Book> findByName(@Param("name") String name);
    // Custom query to match author name
    @Query("SELECT b FROM Book b WHERE LOWER(b.book_author) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<Book> findByAuthor(@Param("author")String author);


}
