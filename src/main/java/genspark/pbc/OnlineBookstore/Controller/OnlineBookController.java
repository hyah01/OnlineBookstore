package genspark.pbc.OnlineBookstore.Controller;

import genspark.pbc.OnlineBookstore.Entity.Book;
import genspark.pbc.OnlineBookstore.Service.OnlineBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineBookController {
    // automatically wire up beans (components) defined in application context and inject them into bs
    @Autowired
    public OnlineBookService bs;

    // Home page
    @GetMapping("/")
    public String home(){
        return "<h1>Welcome to your online book store</h1>";
    }

    // To get all the books Json
    @GetMapping("/Books")
    public List<Book> getBooks(){
        return this.bs.getAllBook();
    }
    @GetMapping("/Books/sorted")
    public List<Book> getSortedBook(){
        return this.bs.getBookSorted();
    }

    // Get Book Json based on name of the book
    @GetMapping("/Books/title")
    public List<Book> getBookByName(@RequestParam String title) {
        return this.bs.getBookByName(title);
    }

    @GetMapping("/Books/titles")
    public List<String> getAllBookTitles() {
        return this.bs.getAllBookTitles();
    }

    // Get Book Json based on name of the author   HOW TO USE (http://localhost:9090/Books/author?author=orw)
    @GetMapping("/Books/author")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return this.bs.getBookByAuthor(author);
    }

    @GetMapping("/Books/authors")
    public List<String> getAllBookAuthors() {
        return this.bs.getAllBookAuthors();
    }

    // Get Book Json based on ONE of the genre
    @GetMapping("/Books/genre/{genre}")
    public List<Book> findBooksByGenre(@PathVariable String genre) {
        return this.bs.getBookByGenre(genre);
    }

    // get book by id
    @GetMapping("/Books/{bookId}")
    public Book getSingleBook(@PathVariable Long bookId) {
        return this.bs.getBookById(bookId);
    }

    // add a new book
    @PostMapping("/Books")
    public Book addBook(@RequestBody Book book){
        return this.bs.addBook(book);
    }

    // update a book
    @PutMapping("/Books")
    public Book updateBook(@RequestBody Book book){
        return this.bs.updateBook(book);
    }

    // delete a book

    @DeleteMapping("/Books/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        return this.bs.deleteBookById(bookId);
    }
}
