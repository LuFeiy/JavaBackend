package java_4_modules.md_5_java8;

import org.junit.Test;

import java.util.Optional;

public class OptionalExample {

    public static String getString() {
        // 模拟方法可能返回null
        return Math.random() > 0.5 ? "Hello" : null;
    }
    public static String getDefault() {
        // 模拟方法可能返回null
        return "body profile";
    }


    //黑暗的历史
    @Test
    public void test_01(){
        String result = getString();
        //显式的null检查
        if (result != null) {
            String upperCasedStr = result.toUpperCase();
            System.out.println(upperCasedStr);
        } else {
            System.out.println("getString() returned null");
        }
    }

    //迎来光明
    @Test
    public void test_02(){
        Optional<String> result = Optional.ofNullable(getString());

        //使用Optional的方法链
        //如果Optional为空，map操作不会执行，因此不会有异常抛出
        result.map(String::toUpperCase)
                .ifPresent(System.out::println);
    }


    //创建Optional对象
    @Test
    public void test_03(){
        // 1.创建一个空的Optional对象
        Optional<Object> empty = Optional.empty();

        // 2.使用非空值创建Optional对象, 如果为空，会立刻抛出异常 NullPointerException
        Optional<String> nonEmpty = Optional.of(getString());

        // 3.使用可能为null的值创建Optional对象
        Optional<String> nullable = Optional.ofNullable(getString());
    }


    //Optional 的api
    @Test
    public void test_04(){
        //isPresent
        Optional<String> nonEmptyOptional = Optional.of(getString());

        //get
        String string = nonEmptyOptional.get();

        //isPresent
        if (nonEmptyOptional.isPresent()) {
            System.out.println("Value is present");
        }

        //isEmpty  Java 11及以上版本
        Optional<String> emptyOptional = Optional.ofNullable(getString());
        /*if (emptyOptional.isEmpty()) {
            System.out.println("Optional is empty");
        }*/

        //ifPresent
        nonEmptyOptional.ifPresent(value -> System.out.println("value is :" + value));

        //orElse, orElseGet, orElseThrow
        String defaultValue = emptyOptional.orElse("default value");
        String dynamicValue = emptyOptional.orElseGet(() -> getDefault());
        String valueOrThrow = emptyOptional.orElseThrow(() -> new RuntimeException("value not found"));
    }

    //转换 map, flatMap
    @Test
    public void test_05(){
        Optional<String> nameOptional = Optional.of("JOHN");

        // 使用map转换值（转为小写）
        Optional<String> lowerNameOptional = nameOptional.map(String::toLowerCase);

        // 使用flatMap链接Optional对象的方法
        Optional<String> firstLetterOptional = nameOptional.flatMap(value -> Optional.of(value.substring(0, 1)));

        lowerNameOptional.ifPresent(value -> System.out.println("Lowercase name: " + value));
        firstLetterOptional.ifPresent(value -> System.out.println("First letter: " + value));
    }
}
