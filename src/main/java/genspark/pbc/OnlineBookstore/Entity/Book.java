package genspark.pbc.OnlineBookstore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long book_Id;
    public String book_name;
    public String book_author;
    public String book_description;
    public String[] book_genre;
    public double price;
}
