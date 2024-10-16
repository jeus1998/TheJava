package com.example.springdi;
public class BookService {
    public void rent(Book book){
        System.out.println("rent: " + book.getTitle());
    }
}
