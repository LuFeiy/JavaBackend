package java_4_modules.md_5_java8;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {



    //1. 创建操作
    //从集合创建
    @Test
    public void test_01(){
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

        //创建流式操作对象
        Stream<String> stream = list.stream();

        stream.forEach(System.out::println);
    }

    //从数组创建
    @Test
    public void test_02(){
        String[] array = new String[]{"Apple", "Banana", "Cherry"};

        Stream<String> stream = Arrays.stream(array);

        stream.forEach(System.out::println);
    }

    //从Stream静态工厂方法创建
    @Test
    public void test_03(){
        //of 也是一个静态方法
        Stream<String> stream1 = Stream.of("Apple", "Banana", "Cherry");


        //range方法
        IntStream stream2 = IntStream.range(1, 5);

        //iterate方法
        Stream<Integer> stream3 = Stream.iterate(0, n -> n + 2).limit(5);

        stream3.forEach(System.out::println);

    }

    //从文件生成
    @Test
    public void test_04() {
        String filePath = "data.txt";

        // 使用类加载器获取资源作为流
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             Stream<String> lines = reader.lines()) {
            lines.forEach(System.out::println);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }




    //2. 中间操作
    // filter
    @Test
    public void test_05(){
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Tom", "Eve");
        names.stream()
                .filter(n -> n.length() > 3)
                .forEach(System.out::println);
    }

    //map
    @Test
    public void test_06(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .map(x -> x *2)
                .forEach(System.out::println);
    }

    //flatmap
    @Test
    public void test_07(){
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        listOfLists.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }


    //distinct 去重
    @Test
    public void test_08(){
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        items.stream()
                .distinct()
                .forEach(System.out::println);
    }


    //sorted
    @Test
    public void test_09(){
        List<Integer> numbers = Arrays.asList(4, 2, 3, 1, 5);
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    //peek
    @Test
    public void test_10(){
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        items.stream()
                .peek(System.out::println);
    }


    //limit
    @Test
    public void test_11(){
        //无限流
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);

        infiniteStream.limit(5)
                .forEach(System.out::println);
    }


    //skip
    @Test
    public void test_12(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);
    }


    //3. 终端操作
    //forEach
    @Test
    public void test_13(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);
    }


    //collect
    @Test
    public void test_14(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> collected = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        collected.forEach(System.out::println);
    }


    //reduce
    @Test
    public void test_15(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);
    }

    //min max
    @Test
    public void test_16(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        min.ifPresent(minValue -> System.out.println("Min: " + minValue));
        max.ifPresent(maxValue -> System.out.println("Max: " + maxValue));
    }

    //count
    @Test
    public void test_17(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        long count = names.stream().count();
        System.out.println("Number of names: " + count);
    }


    //anyMatch, allMatch, noneMatch
    @Test
    public void test_18(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("A"));
        boolean allMatch = names.stream().allMatch(name -> name.length() > 3);
        boolean noneMatch = names.stream().noneMatch(name -> name.endsWith("Z"));

        System.out.println("Any match: " + anyMatch); // true
        System.out.println("All match: " + allMatch); // true
        System.out.println("None match: " + noneMatch); // true
    }


    //收藏器
    //Collectors toList
    @Test
    public void test_19(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        //toList
        List<String> list = names.stream().collect(Collectors.toList());

        //toSet
        Set<String> set = names.stream().collect(Collectors.toSet());

        //toSet
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        //joining
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

        //groupingBy
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Chris");
        Map<Character, List<String>> groupByFirst = names2.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupByFirst);

        //partitioningBy
        List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Chris");
        Map<Boolean, List<String>> partitioned = names3.stream().collect(Collectors.partitioningBy(name -> name.length() > 4));
        System.out.println(partitioned);
    }


    //并行Stream
    @Test
    public void test_20(){
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
        // 创建并行Stream
        strings.parallelStream().forEach(System.out::println);

        //转换
        strings.stream().parallel().forEach(System.out::println);
    }


}
