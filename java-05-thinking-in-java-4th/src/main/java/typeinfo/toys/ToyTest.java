package typeinfo.toys;


interface HashBatteries { }
interface Waterproof { }
interface Shoots { }

interface Plastic{ }


class Toy {
    Toy() {}

    Toy(int i) {}
}


class FancyToy extends Toy implements HashBatteries,Waterproof,Shoots,Plastic {
    FancyToy() {super(1);}
}



public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }


    public static void main(String[] args) {
        Class c = null;


        //获取FancyToy的class对象
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }

        //打印基本信息
        printInfo(c);


        //遍历接口
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        //获取父类的class对象
        Class up = c.getSuperclass();
        Object obj = null;

        try {
            obj = up.newInstance();
        }catch (InstantiationException e){
            e.printStackTrace();
            System.exit(1);
        }catch (IllegalAccessException e){
            e.printStackTrace();
            System.exit(1);
        }

        //打印父类信息
        printInfo(obj.getClass());
    }

}



