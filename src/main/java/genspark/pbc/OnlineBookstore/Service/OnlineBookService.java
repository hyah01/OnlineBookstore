package genspark.pbc.OnlineBookstore.Service;

import genspark.pbc.OnlineBookstore.Entity.Book;

import java.util.List;

public interface OnlineBookService {
    List<Book> getAllBook();
    List<Book> getBookSorted();
    List<Book> getBookByName(String bookName);
    List<Book> getBookByAuthor(String bookAuthor);
    List<Book> getBookByGenre(String genre);
    List<String> getAllBookTitles();
    List<String> getAllBookAuthors();
    Book getBookById(long bookId);
    Book addBook(Book book);
    Book updateBook(Book book);
    String deleteBookById(long bookId);

}
