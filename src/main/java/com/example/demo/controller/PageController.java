package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class PageController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public String loadForm() {
        return "index"; // loads index.html
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        service.addBook(book);
        return "redirect:/";
    }
}

