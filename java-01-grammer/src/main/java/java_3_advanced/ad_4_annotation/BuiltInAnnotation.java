package java_3_advanced.ad_4_annotation;


//@Override

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class ParentClass {
    public void display() {
        System.out.println("Parent display");
    }
}

class ChildClass extends ParentClass {

    @Override
    public void display() {
        System.out.println("Child display");
    }
}


class MyClass {
    @Deprecated
    public void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    public void newMethod() {
        System.out.println("new method, use this.");
    }

    @SuppressWarnings("unchecked")
    public void myMethod() {
        List list = new ArrayList(); // 未经检查的转换警告
        list.add("test");
    }

    @SafeVarargs
    public final void safeVarargsMethod(List<String>... stringLists) {
        for (List<String> list : stringLists) {
            System.out.println(list);
        }
    }
}

@FunctionalInterface
interface SimpleFunctionalInterface {
    void execute();
}



public class BuiltInAnnotation {



    @Test
    public void test_01_override(){
       new ChildClass().display();
    }


    @Test
    public void test_02_Deprecated(){
       new MyClass().oldMethod(); //编译器提示
       new MyClass().newMethod();
    }


    @Test
    public void test_03_SuppressWarnings(){
       new MyClass().myMethod();
    }

    @Test
    public void test_04_SuppressWarnings(){
        new MyClass().safeVarargsMethod();
    }

    @Test
    public void test_04_functionInterface(){
        SimpleFunctionalInterface sfi = () -> {
            System.out.println("Executing....");
        };

        sfi.execute();
    }

}
