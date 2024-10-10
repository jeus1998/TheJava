package org.example;


import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import static net.bytebuddy.matcher.ElementMatchers.named;
public class Masulsa {
    public static void main(String[] args) {
        try {
            // 메소드 재정의
            new ByteBuddy().redefine(Moja.class)
                       .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                       .make().saveIn(new File("C:/Study/WhiteShipLecture/Java/target/classes/"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(new Moja().pullOut());
    }
}
