package genspark.pbc.OnlineBookstore.Service;

import genspark.pbc.OnlineBookstore.Entity.Book;
import genspark.pbc.OnlineBookstore.Repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnlineBookServiceImpl implements OnlineBookService{

    @Autowired
    public BookDAO bookDAO;

    @Override
    public List<Book> getAllBook() {
        return this.bookDAO.findAll();
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        return this.bookDAO.findByName(bookName);
    }

    @Override
    public List<Book> getBookByAuthor(String bookAuthor) {
        return this.bookDAO.findByAuthor(bookAuthor);
    }

    @Override
    public Book getBookById(long bookId) {
        Optional<Book> t = this.bookDAO.findById(bookId);
        Book book = null;
        if (t.isPresent()){
            book=t.get();
        } else {
            throw new RuntimeException(STR."Task Not Found :\{bookId}");
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        return this.bookDAO.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookDAO.save(book);
    }

    @Override
    public String deleteBookById(long bookId) {
        this.bookDAO.deleteById(bookId);
        return "Task Deleted Successfully";
    }
}
