package java_4_modules.md_1_collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Collection1 {


    List list = new ArrayList();
    Queue q = new PriorityQueue();
    Set s = new HashSet();

    Map m = new HashMap();
    LinkedHashMap m1 = new LinkedHashMap<>();


    @Test
    public void test_01_collection(){
        // 创建一个集合
        Collection<String> fruits  = new ArrayList<>();

        // 1. 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        //2.检查是否包含
        System.out.println("Contains Apple? " + fruits.contains("Apple"));

        //3.移除
        fruits.remove("Banana");
        System.out.println("After remove: " + fruits);

        //4.计算集合大小
        System.out.println("Size of collection: " + fruits.size());

        //5. 检查集合是否为空
        System.out.println("Is the collection empty? " + fruits.isEmpty());

        //6.遍历元素
        System.out.println("Elements in the collection:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        //7.将集合转换为数组
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("Array of fruits: " + Arrays.toString(fruitsArray));

        //8.清空集合元素
        fruits.clear();
        System.out.println("Is the collection empty after clear? " + fruits.isEmpty());

        //9.迭代器的使用
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        //获取迭代器
        Iterator<String> iterator = fruits.iterator();

        //使用迭代器遍历集合
        while (iterator.hasNext()) {
            String color = iterator.next();
            System.out.println(color);
        }

    }

    @Test
    public void test_02_list(){
        //1.创建并添加元素
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        //2.通过索引获取元素
        System.out.println("Element at index 1: " + colors.get(1));

        //3.根据索引添加元素
        colors.add(1, "Yellow");
        System.out.println("Element at index 1: " + colors.get(1));

        //4.根据索引移除元素
        colors.remove(2);
        System.out.println("After remove elements at index 2 "+ colors );

        //5.根据索引替换元素
        colors.set(2, "Purple");
        System.out.println("After colors.set(2, \"Purple\")：" + colors);

        //6.获取元素索引
        System.out.println("Index of Red: " + colors.indexOf("Red"));
        System.out.println("Index of Cyan: " + colors.indexOf("Cyan"));

        //7.获取子列表
        List<String> subList = colors.subList(1, 3);
        System.out.println("子列表：" + subList);
    }

    @Test
    public void test_03_queue(){
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");
        System.out.println("Init quene: "+ queue);

        //peek查看头部
        System.out.println("head of the quene: " + queue.peek());

        //element查看头部
        System.out.println("head of the quene: " + queue.element());

        //remove移除并返回头部元素
        System.out.println("removed from the queue:" +queue.remove());

        //poll 和 remove类似，只是为空不抛异常
        System.out.println("poll:" + queue.poll());
        System.out.println("after poll:" + queue);
    }

    @Test
    public void test_04_set(){
        //没有新加方法，只是加了一个会去重的特性
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");
        System.out.println("HashSet content " + set);
    }

    @Test
    public void test_05_map(){
        //创建一个map
        Map<String, Integer> map = new HashMap<>();

        //put添加键值对
        map.put("Alice", 20);
        map.put("Bob", 20);
        map.put("Charlie", 20);

        //get取值
        System.out.println("Age of Alice: " + map.get("Alice"));

        //remove 移除键值对
        map.remove("Charlie");
        System.out.println("Map after removing Charlie: " + map);

        //containsKey 检查键是否存在
        System.out.println("Contains key Bob? " + map.containsKey("Bob"));

        //containsValue 检查值是否存在
        System.out.println("Contains value 25? " + map.containsValue(25));

        //size 获取map大小
        System.out.println("Size of map: " + map.size());

        //判断map是否为空
        System.out.println("Is map empty? " + map.isEmpty());

        //获取键的集合
        System.out.println("Keys in map: " + map.keySet());

        //获取值的集合
        System.out.println("Values in map: " + map.values());

        //使用entrySet遍历键值对
        System.out.println("Entries in map: ");
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
