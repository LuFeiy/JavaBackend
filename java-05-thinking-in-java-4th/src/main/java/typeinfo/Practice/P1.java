package typeinfo.Practice;


/**
 * Exercise 1:
 * In ToyTest.java, comment out Toy's default constructor and explain what happens.
 *
 * Answer:
 * After commenting out Toy's default constructor and running main() method, An error occurred in the line 'obj = up.newInstance;'.
 * the detail error message states: 'Caused by: java.lang.NoSuchMethodException: typeinfo.toys.Toy.<init>()'. The reason for this error
 * is that 'newInstance' method calls the default constructor of class to create an object. Therefore, The error occurred when the no-args
 * constructor comment out
 */


/**
 * Exercise 2:
 * Incorporate a new kind of interface ToyTest.java and verify that it is detected and displayed property.
 *
 * Answer:
 * Add an interface 'interface Plastic{ }' and observe the print info.
 */


/**
 * Exercise 3:
 * Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid. Try downcasting to a circle and see what happens.
 *
 * Answer:
 * The part of Rhomboid is normal, But the error occurred when try to downcast shape to circle. The detail error message is:'class typeinfo.Rhomboid cannot
 * be cast to class typeinfo.Circle'
 */


/**
 * Exercise 4:
 * Modify the previous exercise so that it uses instanceof to check the type before performing the downcast.
 *
 * Answer:
 * As flows function test_02() in Shape.java
 */


/**
 * Exercise 5:
 * Implement a rotate(Shape) method in Shapes.java, such that it checks to see if it is rotating a Circle(and, if so, doesn't perform the operation)

 * Answer:
 * As flows function rotate and test_03() in Shape.java
 */


/**
 * Exercise 6:
 * Modify Shapes.java so that it can 'highlight'(set a flag in) all shapes of a particular type. The toString() method for each derived Shape should
 * indicate whether that Shape is 'highlighted'.

 * Answer:
 * As flows function test_04() in Shape.java
 */


/**
 * Exercise 7:
 * Modify SweetShop.java so that each type of object creation is controlled by a command-line argument. That is, if your command line is 'Java SweetShop Candy,'
 * then only the Candy object is created, Notice how you can control which Class object are loaded via the commandline argument.

 * Answer:
 * See the main method in SweetShop.java
 */


import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Exercise 8:
 * Write a method that takes an object and recursively prints all the classes in that object's hierarchy.

 * Answer:
 * See the main method in SweetShop.java
 */









public class P1 {



    @Test
    public void test_01(){
        //String obj = new String("ABC");
        Date obj = new Date();

        System.out.println(obj);

        Class clz = obj.getClass();
        String tab = "";
        while (clz != null){
            System.out.println(tab + clz);
            clz = clz.getSuperclass();
            tab += "\t";
        }
    }


    @Test
    public void test_02(){
        //String obj = new String("ABC");
        Date obj = new Date();
        new Object();

        System.out.println(obj);

        Class clz = obj.getClass();
        String tab = "";
        while (clz != null){
            System.out.println(tab + clz );
            Field[] declaredFields = clz.getDeclaredFields();
            for (Field field :declaredFields ) {
                System.out.println(field);
            }
            clz = clz.getSuperclass();
            tab += "\t";
        }
    }


    @Test
    public void test_03(){
       char[] cs = new char[10];

        System.out.println(cs.getClass().getSuperclass());

        System.out.println(cs instanceof Object);
    }
}
