package com.example.springdi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceTest {
    BookService bookService;
    @BeforeEach
    public void beforeEach(){
        bookService = (BookService) Proxy.newProxyInstance(
            BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(System.nanoTime());
                    Object result = method.invoke(bookService, args);
                    System.out.println(System.nanoTime());
                    return result;
                }
            });
    }
    @Test
    public void test(){
        Book book = new Book();
        book.setTitle("코믹 메이플스토리");
        bookService.rent(book);
    }
}