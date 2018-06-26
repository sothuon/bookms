package com.example.booklist.controllers;

import com.example.booklist.models.Book;
import com.example.booklist.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/index")
    public String index(Model model){
        List<Book> bookList = this.bookService.getAll();
        model.addAttribute("books",bookList);
        return "book/index";
    }
}

