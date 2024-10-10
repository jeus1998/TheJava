package com.example.springdi;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException{
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> bookClass2 = book.getClass();
        Class<?> bookClass3 = Class.forName("com.example.springdi.Book"); // -> ClassNotFoundException 발생 가능

        Field[] fields = bookClass.getFields(); // 접근 제어자 public field only
        Arrays.stream(fields).forEach(System.out::println);

        Field[] declaredFields = bookClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);

        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.println(f + " " + f.get(book));
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }
        });

        // modifiers 확인하기
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        // 메소드 출력
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        // 생성자 출력
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 부모 클래스 출력
        System.out.println(MyBook.class.getSuperclass());

        // 인터페이스 가져오기
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
    }
}
