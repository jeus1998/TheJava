package com.example.springdi;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException{

        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
    }
}
