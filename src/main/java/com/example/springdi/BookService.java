package com.example.springdi;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
