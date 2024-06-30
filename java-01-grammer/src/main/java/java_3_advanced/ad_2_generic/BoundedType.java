package java_3_advanced.ad_2_generic;


import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//泛型边界的作用
//本来的泛型可以表示任意类型，加入通配符起到了两个作用
//1. 限定 这里的 类型从任意类型,变成了有要求的 某个类的父类或者子类(当然也包括它自己)
//2. 拓展 从某个不定的类型，变成了多个有限制的类型

// 用在类体上
// extends
@Data
class Box2<T extends Number> {
    private T t;
    private List<? super Integer> numberList;



}

//super 这里就不可以了，这个语法上不支持,object是所有类的父类，所以所有的object都可以，任何类型都是object，那都可以了
/*class NumberListHolder<T super Integer> {

}*/


class BoundExample {

    //用到方法上
    public void processList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public List<? extends Number> getNumberList() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        return ints;
    }

    public List<? extends Integer> getOBJList() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = new ArrayList<Double>();
        return ints;
        //return doubles;
    }

    //用在属性上
    private List<? super Number> numbers;

    //用在本地变量
    public void LocalViable() {
        List<? extends CharSequence> charSequences = new ArrayList<String>();
        for (CharSequence cs : charSequences) {
            System.out.println(cs);
        }
    }
}






//通配符:一个问号 ? 表示 某未知类型
class WildCardsExample {

    //无界通配符
    public void printList(List<?> list){
        for (Object item : list) {
            System.out.println();
        }
    }

    //有界通配符
    //上届
    public void processNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
    //下界
    public void addNumbers(List<? super Integer> numbers) {
        numbers.add(123);
    }
}



public class BoundedType {


    @Test
    public void test_01(){
        Box2<Integer> integerBox = new Box2<>();
        Box2<Double> doubleBox = new Box2<>();

        //Box2<String> stringBox = new Box2<>(); // Error: String is not a subtype of Number
    }

}
