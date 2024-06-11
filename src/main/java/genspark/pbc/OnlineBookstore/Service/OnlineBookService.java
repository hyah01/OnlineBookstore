package genspark.pbc.OnlineBookstore.Service;

import genspark.pbc.OnlineBookstore.Entity.Book;

import java.util.List;

public interface OnlineBookService {
    List<Book> getAllBook();
    List<Book> getBookByName(String bookName);
    List<Book> getBookByAuthor(String bookAuthor);
    Book getBookById(long bookId);
    Book addBook(Book book);
    Book updateBook(Book book);
    String deleteBookById(long bookId);
}
