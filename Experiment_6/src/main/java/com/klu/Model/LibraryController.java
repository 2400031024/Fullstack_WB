package com.klu.Model;

import com.klu.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    @GetMapping("/count")
    public int count() {
        return bookList.size();
    }

    @GetMapping("/price")
    public double price() {
        return 299.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        for (Book book : bookList) {
            titles.add(book.getTitle());
        }
        return titles;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "You searched for: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}