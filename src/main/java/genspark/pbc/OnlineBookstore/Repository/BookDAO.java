package genspark.pbc.OnlineBookstore.Repository;

import genspark.pbc.OnlineBookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Long> {
}
