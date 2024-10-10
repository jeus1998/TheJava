package com.example.springdi;

public class Book {
    private String A = "a";
    private static String B = "BOOK";
    private static final String C = "BOOK";
    public String D = "d";
    protected String E = "e";
    public Book(){

    }
    public Book(String a, String d, String e){
        this.A = a;
        this.D = d;
        this.E = e;
    }
    private void f(){
        System.out.println("F");
    }
    public void g(){
        System.out.println("g");
    }
    public int h(){
        return 100;
    }

}
