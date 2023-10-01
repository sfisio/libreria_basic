package com.library.controller;

import com.library.entity.Book;
import com.library.entity.BookUser;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private BookRepository repository;

    @ResponseBody
    @GetMapping("/bookId/{id}")
    public String getBook(@PathVariable("id") Integer id){

        if(bookService.getBook(id) != null){
            Book libro = bookService.getBook(id);
            return "titolo: "+ libro.getTitle()+ " ,autore: " + libro.getAuthor();
        } else
            return "non ho trovato il libro";

    }


    @GetMapping("/viewBooks")
    public String viewBooks(Model model) {
        ArrayList<Book> listaLibriPerUser = new ArrayList<>();
        ArrayList<BookUser> bookUsersList = bookService.getBooksUser();

        for(BookUser bu : bookUsersList){
            listaLibriPerUser.add(bookService.getBook(bu.getISBN_book()));
        }

        model.addAttribute("books", listaLibriPerUser);
        return "view";
    }

    @PostMapping("/viewBooksForUser")
    public String viewBooksForUser(Model model, @ModelAttribute("user") User user) {
        ArrayList<Book> listaLibriPerUser = new ArrayList<>();
        //user =  (User) model.getAttribute("user");
        User userLogin = userService.login(user.getEmail(), user.getPassword());
        ArrayList<BookUser> bookUsersList =
                bookService.getBookUserById_user(userLogin.getId_user());

        for(BookUser bu : bookUsersList){
            listaLibriPerUser.add(bookService.getBook(bu.getISBN_book()));
        }

        model.addAttribute("books", listaLibriPerUser);
        return "view";
    }

    @ResponseBody
    @GetMapping("/book/{isbn}")
    public String getBookISBN(@PathVariable("isbn") String isbn){

        if(bookService.getBook(isbn) != null){
            Book libro = bookService.getBook(isbn);
            return "titolo: "+ libro.getTitle()+ " ,autore: " + libro.getAuthor();}
        else
            return "non ho trovato il libro";

    }

    @PostMapping("/saveBook")
    public String saveBook(Book book, RedirectAttributes attributes) {
        if(bookService.saveBook(book)) {
            attributes.addFlashAttribute("Save successfully");
            return "redirect:/view";
        }
        attributes.addFlashAttribute("Save failed");
        return "redirect/:add-book";
    }


    @PostMapping("/add")
    public String addBook(Book book, Model model) {

        model.addAttribute("isbn", book.getIsbn());
        model.addAttribute("author", book.getAuthor());
        model.addAttribute("title", book.getTitle());
        model.addAttribute("time_added", book.getTime_added());
        model.addAttribute("time_removed", book.getTime_removed());
        model.addAttribute("plot", book.getPlot());
        model.addAttribute("num_readings", book.getNum_readings());
        return "view";
    }

    @PostMapping("/remove-book")
    public String deleteBook(@PathVariable("id") Integer id, Model model) {
        bookService.deleteBook(id);

        return "redirect:/view";
    }

    @PostMapping("/update")
    public String update(Book book, Model model) {
        bookService.updateBook(book);
        return "redirect:/view";
    }


    /*
    @PostMapping("/login")
    public String login(@RequestParam(value = "email", required = true) String email,
                        @RequestParam(value = "password", required = true) String password, Model model) {
        User user = userService.login(email, password);
        if(user != null){
            model.addAttribute("user",user);
            System.out.println(user.getName());
        }
        return "login";
    }

    @GetMapping("/add-book")
    public String createBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookService.createBook(book);
        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("book", bookService.findBookById(id));
        return "update-book";
    }

    @RequestMapping("/update-book/{id}")
    public String updateBook(@PathVariable("id") Integer id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookService.updateBook(book);
        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }

    @RequestMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model) {
        bookService.deleteBook(id);

        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }

     */
}
