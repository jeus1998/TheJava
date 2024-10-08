package com.example.thejava;

/**
 * 클래스이름 / 부모 클래스 / 메소드 시그니처/반환타입 등등 .. 메타데이터
 * 이런 메타 데이터들은 자바 8 이전은 메소드 영역 - jvm runtime data area heap(permanent) 영역에 저장
 * java 8 이후로는 os native memory 저장
 * 모든 쓰레드가 공유하는것은 동일하다.
 */
public class App {
    static String myName; // 클래스 로더에 의해 초기화 2번
    static {
        myName = "jeu";
    }
    private static void work(){
        System.out.println("work");
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(App.class.getClasses()); // Object

        // maybe heap permanent 영역
        Class<App> appClass = App.class; // Class<?> 객체들은 생성하지 않아도 이미 heap에 저장

        // heap young generation
        App app = new App(); // Eden

        // native method ->
        System.out.println(Thread.currentThread().getName());

    }
}
