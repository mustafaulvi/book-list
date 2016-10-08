package hello.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mustafa ULVİ on 10/7/16.
 * <p>
 * An entity Book composed by three fields (bookTitle, author).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author Mustafa ULVİ
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookTitle;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Author> authors;

    public Book() {
    }
    public Book(Long id ) {
        this.id = id;
    }

    public Book(String bookTitle, Set<Author> authors) {
        this.bookTitle = bookTitle;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, bookTitle='%s', author(s)='%s']",
                id, bookTitle, authors);
    }

    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

}
