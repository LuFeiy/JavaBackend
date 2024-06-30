package java_4_modules.md_5_java8;


import lombok.Data;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

class MyInteger{
    public static int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}

@Data
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

public class MethodReference {



    //静态方法的应用
    @Test
    public void test_01(){
        //类名调用
        Comparator<Integer> comparator = (a, b) -> MyInteger.compare(a, b);
        //静态方法的更简单形式
        Comparator<Integer> comparator2 = MyInteger::compare;
    }


    //实例方法的应用
    @Test
    public void test_02(){
        String myString = "test";
        Predicate<String> myStringPredicate = s -> myString.equals(s);
        myStringPredicate.test("test");
        //简化写法
        Predicate<String> myStringPredicate2 = myString::equals;
        myStringPredicate2.test("yuan");
    }

    //任意实例方法
    @Test
    public void test_03(){
        BiPredicate<String, String> predicate = (a, b) -> a.equals(b);
        System.out.println(predicate.test("yuan", "yuan"));
        //简化
        BiPredicate<String, String> predicate2 = String::equals;
        System.out.println(predicate2.test("yuan", "yuan"));
    }

    //构造方法的引用
    @Test
    public void test_04(){
        Function<String, Person> creator = name -> new Person(name);
        creator.apply("liyuan");
        //简化写法
        Function<String, Person> creator2 = Person::new;
        creator2.apply("wangzhonglan");

    }

}
