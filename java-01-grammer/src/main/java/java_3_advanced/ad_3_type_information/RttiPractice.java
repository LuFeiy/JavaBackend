package java_3_advanced.ad_3_type_information;

import java_0_bean.Person;
import org.ini4j.Ini;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class RttiPractice {


    @Test
    public void test_01(){
         //读取配置文件
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("conf.ini")){
            if (input == null) {
                System.out.println("Sorry, unable to find conf.ini");
            }

            //创建ini对象并加载文件
            Ini ini = new Ini();
            ini.load(input);

            //获取配置
            String className = ini.get("sys", "className");

            //根据类名创建对象
            Class<?> clazz = Class.forName(className);
            Person person = (Person) clazz.newInstance();

            person.sayHi();

        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }





    @Test
    public void test_02_Proxy(){

    }
}
