package genspark.pbc.OnlineBookstore.Controller;

import genspark.pbc.OnlineBookstore.Entity.Book;
import genspark.pbc.OnlineBookstore.Service.OnlineBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineBookController {
    @Autowired
    public OnlineBookService bs;

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome to your online book store</h1>";
    }

    @GetMapping("/Books")
    public List<Book> getTasks(){
        return this.bs.getAllBook();
    }

    @GetMapping("/Books/name/{name}")
    public List<Book> getBookByName(@PathVariable String name) {
        return this.bs.getBookByName(name);
    }

    @GetMapping("/Books/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        return this.bs.getBookByAuthor(author);
    }

    @GetMapping("/Books/{bookId}")
    public Book getSingleBook(@PathVariable Long bookId) {
        return this.bs.getBookById(bookId);
    }

    @PostMapping("/Books")
    public Book addBook(@RequestBody Book book){
        return this.bs.addBook(book);
    }
    @PutMapping("/Books")
    public Book updateBook(@RequestBody Book book){
        return this.bs.updateBook(book);
    }

    @DeleteMapping("/Books/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        return this.bs.deleteBookById(bookId);
    }
}
