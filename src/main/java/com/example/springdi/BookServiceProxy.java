package com.example.springdi;

public class BookServiceProxy implements BookService {
    private final BookService target;
    public BookServiceProxy(BookService target) {
        this.target = target;
    }
    @Override
    public void rent(Book book) {
        System.out.println(System.nanoTime());
        target.rent(book);
        System.out.println(System.nanoTime());
    }
}
