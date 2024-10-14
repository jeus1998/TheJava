package com.example.springdi;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class ContainerServiceTest {
    @Test
    public void getObject_BookRepository(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertThat(bookRepository).isNotNull();
    }
    @Test
    public void getObject_BookService(){
        BookService bookService = ContainerService.getObject(BookService.class);
        assertThat(bookService).isNotNull();
        assertThat(bookService.bookRepository).isNotNull();
        assertThat(bookService.bookRepository2).isNull();
    }
}