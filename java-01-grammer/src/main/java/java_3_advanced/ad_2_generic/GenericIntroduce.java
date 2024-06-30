package java_3_advanced.ad_2_generic;

import org.junit.Test;

import java.util.ArrayList;

public class GenericIntroduce {

    //1.没有泛型的世界
    //a. 容器中可以放任意的对象，没有限制
    //b. 取出的时候需要强转,容易抛出异常
    @Test
    public void test_01(){
        ArrayList list = new ArrayList();
        list.add("Hello");
        String s = (String)list.get(0);

        list.add(new Integer(1));
        String s2 = (String)list.get(1);  //编译正常，但是运行会报错
    }


    @Test
    public void test_02(){
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("liyuan");
        String str = listStr.get(0);    //不用强转

        //listStr.add(new Integer(1));    //编译期间就会报错
    }
}
