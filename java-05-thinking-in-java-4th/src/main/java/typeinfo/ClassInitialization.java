package typeinfo;


import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initalbe");
    }
}


class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initalbe2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initalbe3");
    }
}



public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;            // Dose not trigger initialization
        System.out.println("After creating Initable ref");

        System.out.println(Initable.staticFinal);   // Dose not trigger initialization

        System.out.println(Initable.staticFinal2);  // Dose trigger initialization

        System.out.println(Initable2.staticNonFinal);  // Dose trigger initialization

        Class initable3 = Class.forName("typeinfo.Initable3");  // Dose trigger initialization
        System.out.println("After creating Initable3 ref");

        System.out.println(Initable3.staticNonFinal);


    }

}
