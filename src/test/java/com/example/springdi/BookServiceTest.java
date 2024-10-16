package com.example.springdi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

class BookServiceTest {
    BookService bookService;

    /*@BeforeEach -> CGLIB 사용
    public void beforeEach(){
        Callback callback = new MethodInterceptor() {
            BookService bookService = new BookService();
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println(System.nanoTime());
                Object result = method.invoke(bookService, args);
                System.out.println(System.nanoTime());
                return result;
            }
        };
        bookService = (BookService) Enhancer.create(BookService.class, callback);
    }*/
    @DisplayName("ByteBuddy 사용")
    @BeforeEach()
    public void beforeEach() throws Exception{
        Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
                .method(named("rent"))
                .intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService bookService = new BookService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(System.nanoTime());
                        Object result = method.invoke(bookService, args);
                        System.out.println(System.nanoTime());
                        return result;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();
         bookService = proxyClass.getConstructor().newInstance();
    }
    @Test
    public void test(){
        Book book = new Book();
        book.setTitle("코믹 메이플스토리");
        bookService.rent(book);
    }
}