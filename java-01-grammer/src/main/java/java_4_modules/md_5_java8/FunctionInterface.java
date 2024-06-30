package java_4_modules.md_5_java8;

import org.junit.Test;

import java.util.function.*;

public class FunctionInterface {

    //只有一个抽象的方法的接口就是函数式接口
    //这个注解是可选的，不加没问题，但是接口有多个抽象方法，编译器会报错
    //这就是自定义函数式接口
    @FunctionalInterface
    interface Comparator<T> {
        boolean compare(T a, T b);
        //boolean compare2(T a, T b); //dame
    }

    @Test
    public void test_01(){
        Comparator<Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.compare(5,3));
    }


    //常用的函数式接口

    //Consumer<T>
    Consumer<String> printer = s -> System.out.println(s);
    Consumer<String> printer2 = System.out::println;    //这是一个比较高级的同等用法
    @Test
    public void test_02(){
       printer.accept("hello");
       printer2.accept("world");
    }

    //Supplier<T>
    Supplier<Double> valeSupplier = Math::random;
    @Test
    public void test_03(){
        System.out.println(valeSupplier.get());
    }


    //Function<T,R>
    Function<String,Integer> lengthFunction =  String::length;

    @Test
    public void test_04(){
        System.out.println(lengthFunction.apply("hello, world!"));
    }


    //Predicate<T>
    Predicate<String> isNotEmpty = String::isEmpty;
    @Test
    public void test_05(){
        System.out.println(isNotEmpty.test("liyuan"));
    }


    //UnaryOperator<T>
    UnaryOperator<Integer> square = x -> x * x;
    @Test
    public void test_06(){
        System.out.println(square.apply(10));
    }

    //BinaryOperator<T>
    BinaryOperator<Integer> sun = (a, b) -> a + b;
    @Test
    public void test_07(){
        System.out.println(sun.apply(10,25));
    }







}
