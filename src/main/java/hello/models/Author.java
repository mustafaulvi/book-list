package hello.models;

import javax.persistence.*;

/**
 * Created by Mustafa ULVİ on 10/7/16.
 * <p>
 * An entity Author composed by three fields (name, email).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author Mustafa ULVİ
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    public Author() {
    }
    public Author(long id){
        this.id = id;
    }
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Author[id=%d, name='%s', email='%s']",
                id, name, email);
    }


}