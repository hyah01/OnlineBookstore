package genspark.pbc.OnlineBookstore.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// List of query that can be use in BookDAO;
@NamedQueries({
        @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE LOWER(b.book_name) LIKE LOWER(CONCAT('%', :title, '%'))"),
        @NamedQuery(name = "Book.getAuthors", query = "SELECT DISTINCT b.book_author FROM Book b"),
        @NamedQuery(name = "Book.getTitles", query = "SELECT DISTINCT b.book_name FROM Book b"),
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long book_Id;
    public String book_name;
    public String book_author;
    public String book_description;
    public String[] book_genre;
    public double price;

    public String[] getBookGenre(){
        return book_genre;
    }
}
