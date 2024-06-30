package java_3_advanced.ad_2_generic;

import lombok.Data;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;


//1.泛型类
class Box<T> {
    private T t; // T stands for Type

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

//泛型类-多个泛型
@Data
class Pair<K, V> {
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private K key;
    private V value;
}







//2.定义泛型接口
interface IBox<T> {
    void put(T item);

    T get();
}

//使用泛型接口
class IntegerBox implements IBox<Integer> {
    @Override
    public void put(Integer item) {

    }

    @Override
    public Integer get() {
        return null;
    }
}

//也可以不指定泛型,泛型的名字可以和之前的不一样
class IntegerBox2<U> implements IBox<U> {
    @Override
    public void put(U item) {

    }

    @Override
    public U get() {
        return null;
    }
}

//泛型接口案例
@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age,o.age);
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}


//3.泛型方法
class GenericMethodExample {
    //基本的定义方式
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    //多个泛型参数类型
    public static <T, U> void printTwoTypes(T param1, U param2) {
        System.out.println("T: " + param1.toString());
        System.out.println("U: " + param2.toString());
    }

    //非静态方法定义上是一样的
    public <T> void nonStaticGenericMethod(T element) {
        System.out.println(element);
    }


    public GenericMethodExample() {
    }

    //构造方法也可以和普通方法一样使用泛型
    public <U> GenericMethodExample(U value) {
        System.out.println("Value: " + value.toString());
    }

    //返回值也可以使用泛型，语法上可以做到不报错，但是功能实现不了,因为函数体里面需要通过代码得到一个U类型作为返回值，
    //U类型就必须出现在参数类型中
    public static <T,U> U convert1(T input) {
        //do something
        return null;
    }

    //正常的写法
    public static <T,U> U convert(T input, Function<T,U> converter) {
        return converter.apply(input);
    }

}






public class BasicApi {


    //泛型类的使用
    @Test
    public void test_01(){
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.set(10);
        stringBox.set("yuan");

        //integerBox.set("aaa"); insert error

        Integer someInteger = integerBox.get();
        String string = stringBox.get();
    }

    @Test
    public void test_02(){
        Pair<String, Integer> grade = new Pair<>("Math", 90);
        String subject = grade.getKey();
        Integer score = grade.getValue();
    }

    //测试泛型方法
    @Test
    public void test_03(){
       GenericMethodExample.<String>printArray(new String[]{"hello","world"});
       GenericMethodExample.printArray(new String[]{"hello","world"});

       GenericMethodExample.<String,Integer>printTwoTypes("HELLO",123);
       GenericMethodExample.printTwoTypes("HELLO",123);
    }

    //普通泛型方法
    @Test
    public void test_04(){
       new GenericMethodExample().<String>nonStaticGenericMethod("hello");
       new GenericMethodExample().nonStaticGenericMethod("hello");
    }


    //返回值也有泛型
    @Test
    public void test_05(){
        Integer cnt1 = GenericMethodExample.<String,Integer>convert("liyuan", String::length);
        Integer cnt2 = GenericMethodExample.convert("liyuan", String::length);
        System.out.println("cnt:" + cnt2);

        Float aFloat = GenericMethodExample.convert("1234.4", Float::parseFloat);
        System.out.println("aFloat:" + aFloat);
    }
}
