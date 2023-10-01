package com.library.service;

import com.library.entity.Book;
import com.library.entity.BookUser;
import com.library.repository.BookRepository;
import com.library.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookUserRepository bookUserRepository;


    public Book getBook(Integer id){
        if(bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();
        else
            return null;
    }

    public ArrayList<Book> getBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    public ArrayList<BookUser> getBooksUser() {

        return  (ArrayList<BookUser>) bookUserRepository.findAll();
    }

    public ArrayList<BookUser> getBookUserById_user(Integer id_user) {
        return (ArrayList<BookUser>) bookUserRepository.findAllById(Collections.singleton(id_user));
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public boolean saveBook(Book book) {
        Book book1 = bookRepository.save(book);

        if(getBook(book1.getId()) != null) {
            return true;
        }
        return false;
    }

    public boolean deleteBook(Integer id) {

        bookRepository.deleteById(id);

        if(getBook(id) == null) {
            return true;
        }
        return false;

    }


    /*
    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }
     */


    public Book getBook(String isbn){
        if(bookRepository.findByIsbn(isbn) != null)
            return bookRepository.findByIsbn(isbn);
        else
            return null;
    }



    /*
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id);

        bookRepository.deleteById(book.getId());
    }

     */
}
