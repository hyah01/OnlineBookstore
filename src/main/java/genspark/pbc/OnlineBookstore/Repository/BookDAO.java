package genspark.pbc.OnlineBookstore.Repository;

import genspark.pbc.OnlineBookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book,Long> {
    @Query("SELECT * FROM onlinebookdb WHERE book_name = ?")
    List<Book> findByName(String name);

    @Query("SELECT * FROM onlinebookdb WHERE book_author = ?")
    List<Book> findByAuthor(String author);
}
