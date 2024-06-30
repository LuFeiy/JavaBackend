package java_3_advanced.ad_3_type_information;

import java_0_bean.Person;
import org.junit.Test;

import java.lang.reflect.*;


class Employee extends Person {
    private String company;

    public Employee(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}

public class ReflectExample {


    //三种获取Class实例的方法
    @Test
    public void test_01_getClass(){
        // 1.使用类的.class属性
        Class<Person> clazz1 = Person.class;
        //Class<Person> clazz1 = new Person().class;  //没有这样的语法

        System.out.println("clazz1.name:" + clazz1.getSimpleName());

        // 使用实例的getClass()方法
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println("clazz2.name:" + clazz2.getName());

        // 使用Class类的.forName()静态方法
        try {
            Class<?> clazz3 = Class.forName("java_0_bean.Person");
            System.out.println("clazz3.name:" + clazz3.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //如何通过Class的实例创建对象
    @Test
    public void test_02_createObject(){
        try {
            Class<?> clazz = Class.forName("java_0_bean.Person");

            // 1.默认构造函数实例化
            Person person1 = (Person) clazz.newInstance();
            person1.sayHi();


            // 2.获取特定构造函数
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            // 使用构造函数实例化
            Person person2 = (Person) constructor.newInstance("Alice", 30);
            person2.sayHi();

        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    //获取属性
    @Test
    public void test_03_getField(){
        try {
            Class<?> clazz = Class.forName("java_0_bean.Person");
            Person person = (Person) clazz.newInstance();

            // 访问私有字段
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true); // 使私有字段可访问
            nameField.set(person, "Bob"); // 设置字段值

            // 获取字段值
            String name = (String) nameField.get(person);
            System.out.println("The name is: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取和调用方法
    @Test
    public void test_04_callMethod(){
        try {
            Class<?> clazz = Class.forName("java_0_bean.Person");
            Person person = (Person) clazz.newInstance();

            // 调用公共方法(set/get 也可以认为是普通的方法)
            Method setNameMethod = clazz.getMethod("setName", String.class);
            setNameMethod.invoke(person, "Charlie");

            // 调用私有方法
            Method secretMethod = clazz.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true); // 使私有方法可访问,不开启下面调用会报错
            secretMethod.invoke(person);      // 调用时候需要绑定对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取实现的接口和继承的父类
    @Test
    public void test_05_getInterface(){

        Class<Person> personClass = Person.class;
        Class<Employee> employeeClass = Employee.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println("Interfaces implements by " + personClass.getName() + " : ");
        for (Class clazz: interfaces) {
            System.out.println(clazz.getName());
        }


        Class<?> superclass = employeeClass.getSuperclass();
        System.out.println(employeeClass.getName() + " is extend from" + superclass.getName());
    }


    //获取类的修饰符
    @Test
    public void test_06_getModifiers(){
        Class<Person> personClass = Person.class;

        int modifiers = personClass.getModifiers();

        System.out.println("Class Modifiers for " + personClass.getName() + " : " + Modifier.toString(modifiers));
    }






}
