package java_3_advanced.ad_3_type_information;

import org.junit.Test;

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class RTTIExample {



    @Test
    public void test_01(){
        Animal animal = new Dog(); // 实际对象是Dog

        // 1.使用instanceof来检查对象类型,实际过程这个对象可能是外部传入或手受外部影响的
        if (animal instanceof Dog) {
            System.out.println("This is a Dog");
        } else if (animal instanceof Cat) {
            System.out.println("This is a Cat");
        }

        // 2. 使用getClass()来获取对象的实际类
        Class<?> animalClass = animal.getClass();
        System.out.println("The actual class of animal is: " + animalClass.getSimpleName());

    }
}
