package hello.controllers;


/**
 * Created by usr on 9/28/16.
 */

import hello.models.Author;
import hello.models.Book;
import hello.models.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Mustafa ULVİ on 10/7/16.
 *
 * A class to test interactions with the MySQL database using the BookDao class.
 *
 * @author Mustafa Ulvi
 */
@Controller
public class BookController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /create  --> Create a new Book and save it in the database.
     *
     * @param bookTitle Book's bookTitle
     * @param authors  Book's author
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping("/createBook")
    @ResponseBody
    public String createBook(String bookTitle, Set<Author> authors) {
        Book book = null;
        try {
            book = new Book(bookTitle, authors);
            getBookDao().save(book);
        } catch (Exception ex) {
            return "Error creating the book: " + ex.toString();
        }
        return "Book succesfully created! (id = " + book.getId() + ")";
    }

    /**
     * /delete  --> Delete the Book having the passed id.
     *
     * @param id The id of the book to delete
     * @return A string describing if the book is succesfully deleted or not.
     */
    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(long id) {
        try {
            Book book = new Book(id);
            getBookDao().delete(book);
        } catch (Exception ex) {
            return "Error deleting the book: " + ex.toString();
        }
        return "Book succesfully deleted!";
    }


    /**
     * /update  --> Update the bookTitle and the author for the book in the database
     * having the passed id.
     *
     * @param id    The id for the book to update.
     * @param bookTitle The new bookTitle.
     * @param authors  The new author.
     * @return A string describing if the book is succesfully updated or not.
     */
    @RequestMapping("/updateBook")
    @ResponseBody
    public String updateBook(long id, String bookTitle, Set<Author> authors) {
        try {
            Book book = getBookDao().findOne(id);
            book.setBookTitle(bookTitle);
            book.setAuthors(authors);
            getBookDao().save(book);
        } catch (Exception ex) {
            return "Error updating the book: " + ex.toString();
        }
        return "Book succesfully updated!";
    }


    /**
     * /get-All-Book  --> Return all books
     *
     * @return The all book or a message error if the book is not found.
     */
    @RequestMapping("/getAllBooks")
    @ResponseBody
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books;
        try {
            books= (ArrayList<Book>) getBookDao().findAll();
        }
        catch (Exception ex) {
            return null;
        }
        return books;
    }



    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
} // class BookController
