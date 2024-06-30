package java_3_advanced.ad_4_annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.junit.Test;



/**
 * 1. 注解也是可以有值的，可以是单个值或者多个值
 * 2. 如果是单个值，用value最好，不然使用时需要用 key= 这样的语法
 * 3. 注解最后也是一个对象，绑定到某个对象(类型对象，方法对象，域对象)
 * 4. 通过field.isAnnotationPresent(JsonField.class)来判断一个域上有没有添加特定的注解
 * 5. 注解是要与注解解释器一起工作的
 */


//demo1:annotation on field

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface  JsonField {
    String value() default "";
}

class Person {

    @JsonField("姓名")
    private String name;

    @JsonField("年龄")
    private Integer age;

    @JsonField
    private String gender;

    private String Phone;

    public Person(String name, Integer age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        Phone = phone;
    }
}


class JsonSerializer {

    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        JSONObject json = new JSONObject();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.value().isEmpty() ? field.getName() : annotation.value();
                Object fieldValue = field.get(object);
                json.put(jsonKey, fieldValue);
            }
        }
        return json.toString();
    }
}


//demo2:annotation on method
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodInfo {
    //注解的元素定义，包含默认值
    String author() default "Unknown";

    String date();

    int version() default 1;
}

class Example{

    @MethodInfo(author = "Yuan li",date = "2024-05-10",version = 2)
    public void exampleMethod() {
        System.out.println("This is an example method.");
    }
}






public class MetaAnnotation {

    @Test
    public void test_01(){
        Person person = new Person("LIYUAN",32,"男","199");

        try {
            String json = JsonSerializer.serialize(person);
            System.out.println(json);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void test_02(){

        for (Method method : Example.class.getDeclaredMethods() ) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("Method Name:" + method.getName());
                System.out.println("Author:" + methodInfo.author());
                System.out.println("Date:" + methodInfo.date());
                System.out.println("Version:" + methodInfo.version());
            }
        }
    }

}
