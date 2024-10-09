package com.example.thejava;

public class App {
    public static void main(String[] args) {
        Class<App> appClass1 = App.class; // 로딩 시점에 만들어진 Class<App> 객체 -> 힙 영역에 저장
        App app = new App();
        Class<? extends App> appClass2 = app.getClass();

        ClassLoader classLoader = App.class.getClassLoader();
        // -> ApplicationClassLoader (사용자 정의) -> AppClassLoader
        System.out.println(classLoader);

        // -> ExtensionClassLoader -> PlatformClassLoader
        System.out.println(classLoader.getParent());

        // -> BootstrapClassLoader -> null Native 코드로 구현
        System.out.println(classLoader.getParent().getParent());
    }
}
