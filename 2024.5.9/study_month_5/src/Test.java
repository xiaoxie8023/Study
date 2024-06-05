/**
 * program: 2024.5.9
 * <p>
 * description:
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-06-05 17:22
 **/
class A {
    public A() {
        System.out.println("A");
    }
    static {
        System.out.println("A static");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
    static {
        System.out.println("B static");
    }
}

public class Test {
    static B b = new B();
    public static void main(String[] args) {
        new A();
        new B();
    }
}