package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class PageController {

    @Autowired
    private BookService service;

    // Load page + table
    @GetMapping("/")
    public String loadPage(Model model) {
        model.addAttribute("book", new Book());               // form binding
        model.addAttribute("books", service.fetchBooks());    // table data
        return "index";
    }

    // Save data + refresh page
    @PostMapping("/save")
    public String saveBook(Book book) {
        service.addBook(book);   // INSERT INTO DB
        return "redirect:/";     // REFRESH PAGE
    }
}

