package java_0_bean;

public class Person implements Walk{

    private String name;
    private int age;

    public Person() {
        // 默认构造函数
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void secretMethod() {
        System.out.println("This is a secret method.");
    }

    public void sayHi() {
        System.out.println("hello every body!");
    }

    @Override
    public void walking() {
        System.out.println("People is Walking");
    }
}
