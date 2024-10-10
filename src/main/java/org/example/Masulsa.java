package org.example;


import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import static net.bytebuddy.matcher.ElementMatchers.named;
public class Masulsa {
    public static void main(String[] args) {
        System.out.println(new Moja().pullOut());
    }
}

/* 순서에 너무 의존적
public static void main(String[] args) {
    ClassLoader classLoader = Masulsa.class.getClassLoader();
    TypePool typePool = TypePool.Default.of(classLoader);

    try {
        // 메소드 재정의
        new ByteBuddy().redefine(
                    typePool.describe("org.example.Moja").resolve(),
                    ClassFileLocator.ForClassLoader.of(classLoader))
                   .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                   .make().saveIn(new File("C:/Study/WhiteShipLecture/Java/target/classes/"));
    }
    catch (IOException e){
        e.printStackTrace();
    }
    System.out.println(new Moja().pullOut());
}
 */