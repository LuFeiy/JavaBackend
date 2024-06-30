package java_4_modules.md_1_collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticInCollections {

/*
*
排序 (Collections.sort())
混排 (Collections.shuffle())
查找 (Collections.binarySearch())
比较 (Comparator 和 Comparable 接口)
复制 (Collections.copy())
反转 (Collections.reverse())
最大值与最小值 (Collections.max(), Collections.min())
*
*  */


    @Test
    public void test_01_sort(){
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void test_02_comparable(){
        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        Collections.sort(words, Comparator.reverseOrder());
        System.out.println(words);
    }

    @Test
    public void test_03_shuffle(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.shuffle(numbers);
        System.out.println(numbers);
    }

    @Test
    public void test_04_binarySearch(){
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        int index = Collections.binarySearch(sortedList, 5);
        System.out.println(index);
    }

    @Test
    public void test_05_copy(){
        List<Integer> src = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> desc = Arrays.asList(new Integer[src.size()]);

        Collections.copy(desc,src);
        System.out.println(desc);
    }


    //Arrays API,操作数组的api
    /**
     * 方法描述:排序 (Sorting):
     * Arrays.sort(array): 对给定的数组进行自然排序（升序）。
     * Arrays.sort(array, fromIndex, toIndex): 对数组指定范围内的元素进行排序。
     * Arrays.sort(array, comparator): 使用自定义的 Comparator 对象来排序数组。
     */
    @Test
    public void test_01_Arrays_sort(){
        int[] numbers = {9, 3, 6, 2, 7};
        //排序
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        //搜索
        int index = Arrays.binarySearch(numbers, 6);
        System.out.println("Index of 6 : " + index);
    }


    @Test
    public void test_02_Arrays_copy(){
        // 初始化一个数组
        int[] original = {1, 2, 3, 4, 5};

        //复制数组
        int[] copied = Arrays.copyOf(original, 5);
        System.out.println("Copied array: " + Arrays.toString(copied));

        //填充数组
        Arrays.fill(copied,0);
        System.out.println("Array after fill: " + Arrays.toString(copied));
    }

    @Test
    public void test_03_Arrays_transList(){
        // 创建一个包装类型的数组
        String[] stringArray = {"Apple", "Banana", "Cherry"};

        //转换为列表
        List<String> list = Arrays.asList(stringArray);
        System.out.println("List: " + list);

        //流式操作
        String result = Arrays.stream(stringArray)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Comma-separated: " + result);
    }
}
