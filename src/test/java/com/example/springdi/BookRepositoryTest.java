package com.example.springdi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    BookService bookService;
    @BeforeEach
    public void beforeEach(){
        bookService = new BookServiceProxy(new DefaultBookService());
    }
    @Test
    public void test(){
        Book book = new Book();
        book.setTitle("코믹 메이플스토리");
        bookService.rent(book);
    }
}