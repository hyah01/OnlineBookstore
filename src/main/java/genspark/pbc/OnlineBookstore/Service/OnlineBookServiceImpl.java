package genspark.pbc.OnlineBookstore.Service;

import genspark.pbc.OnlineBookstore.Entity.Book;
import genspark.pbc.OnlineBookstore.Repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<String> getAllBookTitles(){
        return this.bookDAO.getTitles();
    }

    @Override
    public List<Book> getBookByAuthor(String bookAuthor) {
        return this.bookDAO.findByAuthor(bookAuthor);
    }

    @Override
    public List<String> getAllBookAuthors(){
        return this.bookDAO.getAuthors();
    }

    @Override
    public List<Book> getBookSorted(){
        return this.bookDAO.getAllBookSorted();
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
            List<Book> allBooks = this.bookDAO.findAll(); // Get all the books
            List<Book> matchingBooks = new ArrayList<>(); // Stores the books that matches the genre
            for (Book book : allBooks) {
                // For each book we look at all the genre
                for (String bookGenre : book.getBookGenre()) {
                    // If genre matches, add to list
                    if (bookGenre.toLowerCase().contains(genre.toLowerCase())) {
                        matchingBooks.add(book);
                        break; // Exit inner loop once a match is found
                    }
                }
            }
            return matchingBooks;
    }

    @Override
    public Book getBookById(long bookId) {
        Optional<Book> t = this.bookDAO.findById(bookId);
        Book book = null;
        // if book exist, return it
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
