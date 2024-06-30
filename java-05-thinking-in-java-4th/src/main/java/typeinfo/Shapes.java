package typeinfo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Shape {

    boolean highlight = false;

    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();


    void rotate(){
        if (this instanceof Circle){
            System.out.println("Rotating Circle doesn't make sense.");
        }
    }
}

class Circle extends Shape {
    public String toString() { return "Circle" + " highlighted "+ highlight; }
}
class Square extends Shape {
    boolean highlight = true;
    public String toString() { return "Square" + " highlighted "+ highlight; }
}
class Triangle extends Shape {
    public String toString() { return "Triangle" + " highlighted "+ highlight; }
}

class Rhomboid extends Shape {
    public String toString() { return "Rhomboid" + " highlighted "+ highlight; }
}


public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );

        for (Shape shape : shapeList) {
            shape.draw();
        }
    }



    @Test
    public void test_01(){

        Rhomboid rhomboid = new Rhomboid();
        Shape shape = (Shape)rhomboid;
        Rhomboid rhomboid_new = (Rhomboid)shape;

        Circle circle = (Circle)shape;

    }


    @Test
    public void test_02(){

        Rhomboid rhomboid = new Rhomboid();
        Shape shape = (Shape)rhomboid;
        Rhomboid rhomboid_new = (Rhomboid)shape;

        if (shape instanceof Circle){
            Circle circle = (Circle)shape;
        }else {
            System.out.println("shape is not Circle class,can not be casted to Circle");
        }
    }


    @Test
    public void test_03(){
        Circle circle = new Circle();
        circle.rotate();
    }


    @Test
    public void test_04(){
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println(circle);
        System.out.println(square);
    }
}





