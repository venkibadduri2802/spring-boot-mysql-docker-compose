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

    @GetMapping("/")
    public String loadForm(Model model) {
        model.addAttribute("books", service.fetchBooks()); // for table
        model.addAttribute("book", new Book());            // for form binding
        return "index";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        service.addBook(book);
        return "redirect:/";
    }
}

