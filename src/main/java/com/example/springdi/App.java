package com.example.springdi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception{
        Class<Book> bookClass = Book.class;
        Constructor<Book> constructor = bookClass.getConstructor();
        Book book = constructor.newInstance();
        System.out.println(book);

        Constructor<Book> constructor2 = bookClass.getConstructor(String.class);
        Book book2 = constructor2.newInstance("myBook");
        System.out.println(book2);

        // static 필드 가져오기
        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null)); // static 필드는 특정 object 마다 있는게 아닌 모든 object에 있다.

        // static 필드 수정
        a.set(null, "AAAAAA");
        System.out.println(a.get(null));


        // 인스턴스 변수
        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));

        // 인스턴스 변수 수정
        b.set(book, "BBBBB");
        System.out.println(b.get(book));

        // 반환타입과 매개변수가 없는 인스턴스 메소드
        Method c = Book.class.getDeclaredMethod("c");
        c.invoke(book); // 메소드

        // 반환타입과 매개변수가 있는 인스턴스 메소드
        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int result = (int) sum.invoke(book, 10, 20);
        System.out.println(result); // 10 + 20 -> 30

    }
}
