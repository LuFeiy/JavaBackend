package java_3_advanced.ad_1_exception;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;


class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class InvalidRuntimeException extends RuntimeException {
    public InvalidRuntimeException(String message) {
        super(message);
    }
}

public class ExceptionPractice {


    @Test
    public void test_01(){
        try {
            FileReader file = new FileReader("a.txt");
            BufferedReader fileInput = new BufferedReader(file);
            //读取文件内容

            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void test_02(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄：");
        String ageStr = scanner.nextLine();

        try {
            int age = Integer.parseInt(ageStr);
            if (age < 0) {
                throw new IllegalArgumentException("年龄不能为负");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("年龄不能为负：" + e.getMessage());
        }
    }


    @Test
    public void test_03(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("a.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //读取文件
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("文件处理错误：" + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("关闭文件读取器时发生错误：" + e.getMessage());
            }
        }
    }


    @Test
    public void test_04(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"))) {
            //读取文件
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("处理文件时发生错误：" + e.getMessage());
        }
    }

    @Test
    public void test_05() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String name = scanner.nextLine();

        if (name.startsWith("A")){
            throw new InvalidInputException("不能以A开头");
        }

    }

    @Test
    public void test_06(){
        double x = Math.random();
        System.out.println(x);
        assert x > 0.5 : "x 应该大于0，但计算的值为 " + x;
    }
}
