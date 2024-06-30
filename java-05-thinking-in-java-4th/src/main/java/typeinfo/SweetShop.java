package typeinfo;


import org.junit.Test;

class Candy {
    static { System.out.println("Loading Candy"); }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}



public class SweetShop {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                Class.forName(args[i]);
            }catch (ClassNotFoundException e) {
                System.out.println("Can't load Class: " + args[i]);
            }
        }
    }


    @Test
    public void mian_bak(){
        System.out.println("inside main");
        new Candy();

        System.out.println("After creating Candy");
        try {
            Class.forName("typeinfo.Gum");
        }catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }

        System.out.println("After Class.forName(\"typeinfo.Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
