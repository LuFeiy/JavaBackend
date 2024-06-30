package java_4_modules.md_5_java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Concept {
    //语法
    //(parameters) -> expression
    //或者
    //(parameters) -> { statements; }

    //lambda基本使用
    @Test
    public void test_01(){
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(e -> System.out.println(e));
    }
}
