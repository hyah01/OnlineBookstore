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
    List<Book> findByName(String title); // query is stored in Book.class
    // Custom query to match author name
    @Query("SELECT b FROM Book b WHERE LOWER(b.book_author) LIKE LOWER(CONCAT('%', :author, '%'))") // direct query (only doing this to know how it works)
    List<Book> findByAuthor(@Param("author")String author); // need @Param

    @Query(value= "SELECT * FROM Book ORDER BY book_name", nativeQuery = true) // Native query
    List<Book> getAllBookSorted();

    List<String> getAuthors();
    List<String> getTitles();


}
